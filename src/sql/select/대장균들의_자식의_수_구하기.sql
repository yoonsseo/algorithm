/*
 ECOLI_DATA 테이블 ID, PARENT_ID, SIZE_OF_COLONY, DIFFERENTIATION_DATE, GENOTYPE 은
 각각 대장균 개체의 ID, 부모 개체의 ID, 개체의 크기, 분화되어 나온 날짜, 개체의 형질을 나타냅니다.

 대장균 개체의 ID(ID)와 자식의 수(CHILD_COUNT)를 출력하는 SQL 문을 작성해주세요.
 자식이 없다면 자식의 수는 0으로 출력해주세요.
 이 때 결과는 개체의 ID 에 대해 오름차순 정렬해주세요.
 */

SELECT P.ID,
       IFNULL(COUNT(C.ID), 0) AS CHILD_COUNT
FROM ECOLI_DATA AS P
         LEFT JOIN ECOLI_DATA AS C
                   ON P.ID = C.PARENT_ID
GROUP BY P.ID
ORDER BY P.ID ASC;

/*
 LEFT JOIN: 부모 개체와 자식 개체를 연결할 때 LEFT JOIN을 사용하여 부모가 존재하더라도 자식이 없으면 자식의 수를 0으로 나타내도록 합니다.
 SELECT 절: 부모 개체의 ID (P.ID)와 자식의 수 (IFNULL(COUNT(C.ID), 0))를 선택합니다.
 GROUP BY 절: 부모 개체의 ID를 기준으로 그룹화하여 자식의 수를 세게 합니다.
 ORDER BY 절: 부모 개체의 ID를 기준으로 오름차순 정렬합니다.
 */