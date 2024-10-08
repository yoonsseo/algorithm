/*
 CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블 HISTORY_ID, CAR_ID, START_DATE, END_DATE 는
 각각 자동차 대여 기록 ID, 자동차 ID, 대여 시작일, 대여 종료일을 나타냅니다.

 CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서
 대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차들에 대해서
 해당 기간 동안의 월별 자동차 ID 별 총 대여 횟수(컬럼명: RECORDS) 리스트를 출력하는 SQL문을 작성해주세요.
 결과는 월을 기준으로 오름차순 정렬하고, 월이 같다면 자동차 ID를 기준으로 내림차순 정렬해주세요.
 특정 월의 총 대여 횟수가 0인 경우에는 결과에서 제외해주세요.
 */

SELECT MONTH(C.START_DATE) AS MONTH, CAR_ID, COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS C
WHERE C.START_DATE BETWEEN "2022-08-01" AND "2022-10-31"
  AND C.CAR_ID IN (SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE BETWEEN "2022-08-01" AND "2022-10-31"
    GROUP BY CAR_ID
    HAVING COUNT(CAR_ID) >= 5
    )
GROUP BY C.CAR_ID, MONTH
-- 특정 월의 총 대여 횟수가 0인 경우에는 결과에서 제외해주세요. 조건을 위해
-- HAVING절을 추가해주었어도 됐으나 없어도 정답 처리가 됐다
ORDER BY MONTH ASC, CAR_ID DESC;