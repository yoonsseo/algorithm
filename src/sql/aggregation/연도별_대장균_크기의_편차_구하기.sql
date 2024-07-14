/*
 ECOLI_DATA 테이블의 ID, PARENT_ID, SIZE_OF_COLONY, DIFFERENTIATION_DATE, GENOTYPE 은
 각각 대장균 개체의 ID, 부모 개체의 ID, 개체의 크기, 분화되어 나온 날짜, 개체의 형질을 나타냅니다.

분화된 연도(YEAR), 분화된 연도별 대장균 크기의 편차(YEAR_DEV), 대장균 개체의 ID(ID) 를 출력하는 SQL 문을 작성해주세요.
 분화된 연도별 대장균 크기의 편차는 분화된 연도별 가장 큰 대장균의 크기 - 각 대장균의 크기로 구하며
 결과는 연도에 대해 오름차순으로 정렬하고 같은 연도에 대해서는 대장균 크기의 편차에 대해 오름차순으로 정렬해주세요.
 */

SELECT YEAR(ED.DIFFERENTIATION_DATE) AS YEAR,
    ((SELECT MAX(SIZE_OF_COLONY)
    FROM ECOLI_DATA
    WHERE YEAR = YEAR(DIFFERENTIATION_DATE)
    GROUP BY YEAR(DIFFERENTIATION_DATE))
    - ED.SIZE_OF_COLONY) AS YEAR_DEV,
    ID
FROM ECOLI_DATA AS ED
ORDER BY YEAR ASC, YEAR_DEV ASC
;
/*
 GROUP BY 절이 없으면 서브쿼리는 모든 DIFFERENTIATION_DATE에 대해 최대 값을 반환하게 되어,
 각 연도별로 올바른 최대값을 가져오지 못할 수 있습니다.
 모든 연도에 대한 최대값을 계산하게 되어,
 각 연도별로 올바른 결과를 보장받지 못할 수 있습니다.
 */