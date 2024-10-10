/*
 ECOLI_DATA 테이블 ID, PARENT_ID, SIZE_OF_COLONY, DIFFERENTIATION_DATE, GENOTYPE 은
 각각 대장균 개체의 ID, 부모 개체의 ID, 개체의 크기, 분화되어 나온 날짜, 개체의 형질을 나타냅니다.

 대장균 개체의 크기를 내름차순으로 정렬했을 때 상
 위 0% ~ 25% 를 'CRITICAL', 26% ~ 50% 를 'HIGH', 51% ~ 75% 를 'MEDIUM', 76% ~ 100% 를 'LOW' 라고 분류합니다.
 대장균 개체의 ID(ID) 와 분류된 이름(COLONY_NAME)을 출력하는 SQL 문을 작성해주세요.
 이때 결과는 개체의 ID 에 대해 오름차순 정렬해주세요 .
 단, 총 데이터의 수는 4의 배수이며 같은 사이즈의 대장균 개체가 서로 다른 이름으로 분류되는 경우는 없습니다.
 */

SELECT ID,
       (CASE
            WHEN PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) BETWEEN 0 AND 0.25
            THEN "CRITICAL"
            WHEN PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) BETWEEN 0.25 AND 0.5
            THEN "HIGH"
            WHEN PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) BETWEEN 0.5 AND 0.75
            THEN "MEDIUM"
            ELSE "LOW"
           END) AS COLONY_NAME
FROM ECOLI_DATA
ORDER BY ID ASC;

SELECT ID,
       (CASE
            WHEN R BETWEEN 0 AND 0.25
                THEN "CRITICAL"
            WHEN R BETWEEN 0.25 AND 0.5
                THEN "HIGH"
            WHEN R BETWEEN 0.5 AND 0.75
                THEN "MEDIUM"
            ELSE "LOW"
           END) AS COLONY_NAME
FROM (SELECT ID, PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) AS R
      FROM ECOLI_DATA) AS E
ORDER BY ID ASC;
