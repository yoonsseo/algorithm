/*
 CAR_RENTAL_COMPANY_CAR 테이블 CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS 는
 각각 자동차 ID, 자동차 종류, 일일 대여 요금(원), 자동차 옵션 리스트를 나타냅니다.

 CAR_RENTAL_COMPANY_CAR 테이블에서
 '통풍시트', '열선시트', '가죽시트' 중 하나 이상의 옵션이 포함된 자동차가
 자동차 종류 별로 몇 대인지 출력하는 SQL문을 작성해주세요.
 이때 자동차 수에 대한 컬럼명은 CARS로 지정하고,
 결과는 자동차 종류를 기준으로 오름차순 정렬해주세요.
 */

SELECT C.CAR_TYPE, COUNT(C.CAR_ID) AS CARS
FROM CAR_RENTAL_COMPANY_CAR AS C
WHERE C.OPTIONS LIKE "%통풍시트%"
   OR C.OPTIONS LIKE "%열선시트%"
   OR C.OPTIONS LIKE "%가죽시트%"
GROUP BY C.CAR_TYPE
ORDER BY C.CAR_TYPE ASC;