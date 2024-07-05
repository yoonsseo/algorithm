SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE
FROM FOOD_PRODUCT
WHERE PRICE = (SELECT MAX(PRICE) AS PRICE FROM FOOD_PRODUCT)
;

-- WHERE절에서는 집계함수를 사용할 수 없다

/*
SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, MAX(PRICE) AS PRICE
FROM FOOD_PRODUCT
;
 */
-- 왜 위의 쿼리는 정답이 아닌지 모르겠다
-- 정답인 쿼리는 테이블에서 가장 높은 가격을 가진 모든 제품들을 반환하지만
-- 정답이 아닌 쿼리는 테이블 전체에서 가장 높은 가격을 가진 하나의 제품만을 반환
-- 그런데 테스트케이스를 돌려봤을 때는 둘 다 하나만 나왔는데..?
-- 예를 들면 최고 가격이 19000일 때 분명 PRICE가 19000인 값이 여러 개 있었다..
-- ㅠㅠㅠ