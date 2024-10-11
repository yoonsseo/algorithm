/*
 문제 설명
다음은 식품의 정보를 담은 FOOD_PRODUCT 테이블입니다.
 FOOD_PRODUCT 테이블은 다음과 같으며 PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE는
 식품 ID, 식품 이름, 식품코드, 식품분류, 식품 가격을 의미합니다.

Column name	Type	Nullable
PRODUCT_ID	VARCHAR(10)	FALSE
PRODUCT_NAME	VARCHAR(50)	FALSE
PRODUCT_CD	VARCHAR(10)	TRUE
CATEGORY	VARCHAR(10)	TRUE
PRICE	NUMBER	TRUE

 문제
FOOD_PRODUCT 테이블에서 식품분류별로 가격이 제일 비싼 식품의 분류, 가격, 이름을 조회하는 SQL문을 작성해주세요.
 이때 식품분류가 '과자', '국', '김치', '식용유'인 경우만 출력시켜 주시고
 결과는 식품 가격을 기준으로 내림차순 정렬해주세요.
 */

SELECT CATEGORY, PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT AS P
WHERE CATEGORY IN ("과자", "국", "김치", "식용유")
  AND PRICE = (SELECT MAX(PRICE) FROM FOOD_PRODUCT WHERE P.CATEGORY = CATEGORY)
ORDER BY PRICE DESC;