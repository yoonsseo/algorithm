/*
 문제 설명
CART_PRODUCTS 테이블은 장바구니에 담긴 상품 정보를 담은 테이블입니다.
 CART_PRODUCTS 테이블의 구조는 다음과 같으며,
 ID, CART_ID, NAME, PRICE는 각각 테이블의 아이디, 장바구니의 아이디, 상품 종류, 가격을 나타냅니다.

NAME	TYPE
ID	INT
CART_ID	INT
NAME	VARCHAR
PRICE	INT

데이터 분석 팀에서는 우유(Milk)와 요거트(Yogurt)를 동시에 구입한 장바구니가 있는지 알아보려 합니다.
 우유와 요거트를 동시에 구입한 장바구니의 아이디를 조회하는 SQL 문을 작성해주세요.
 이때 결과는 장바구니의 아이디 순으로 나와야 합니다.
 */

SELECT DISTINCT CART_ID
FROM CART_PRODUCTS
WHERE CART_ID IN (SELECT CART_ID FROM CART_PRODUCTS WHERE NAME = "Milk")
  AND CART_ID IN (SELECT CART_ID FROM CART_PRODUCTS WHERE NAME = "Yogurt")
ORDER BY CART_ID ASC;