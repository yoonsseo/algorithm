/*
 CAR_RENTAL_COMPANY_CAR 테이블 CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS 는
 각각 자동차 ID, 자동차 종류, 일일 대여 요금(원), 자동차 옵션 리스트를 나타냅니다.

 CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블 HISTORY_ID, CAR_ID, START_DATE, END_DATE 는
 각각 자동차 대여 기록 ID, 자동차 ID, 대여 시작일, 대여 종료일을 나타냅니다.

 CAR_RENTAL_COMPANY_CAR 테이블과 CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서
 자동차 종류가 '세단'인 자동차들 중 10월에 대여를 시작한 기록이 있는 자동차 ID 리스트를 출력하는 SQL문을 작성해주세요.
 자동차 ID 리스트는 중복이 없어야 하며, 자동차 ID를 기준으로 내림차순 정렬해주세요.
 */

SELECT DISTINCT(C.CAR_ID)
FROM CAR_RENTAL_COMPANY_CAR AS C
         JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H
              ON C.CAR_ID = H.CAR_ID
WHERE C.CAR_TYPE = "세단"
  AND C.CAR_ID IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                   WHERE START_DATE LIKE "%-10-%")
ORDER BY C.CAR_ID DESC;