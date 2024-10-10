/*
 FOOD_ORDER 테이블 ORDER_ID, PRODUCT_ID, AMOUNT, PRODUCE_DATE, IN_DATE,OUT_DATE,FACTORY_ID, WAREHOUSE_ID는
 각각 주문 ID, 제품 ID, 주문양, 생산일자, 입고일자, 출고일자, 공장 ID, 창고 ID를 의미합니다.

 FOOD_ORDER 테이블에서 2022년 5월 1일을 기준으로 주문 ID, 제품 ID, 출고일자, 출고여부를 조회하는 SQL문을 작성해주세요.
 출고여부는 2022년 5월 1일까지 출고완료로 이후 날짜는 출고 대기로 미정이면 출고미정으로 출력해주시고,
 결과는 주문 ID를 기준으로 오름차순 정렬해주세요.
 */

SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, "%Y-%m-%d") AS OUT_DATE,
       (CASE
            WHEN OUT_DATE IS NULL
                THEN "출고미정"
            WHEN DATE_FORMAT(OUT_DATE, "%Y-%m-%d") <= '2022-05-01'
                THEN "출고완료"
            ELSE "출고대기"
           END) AS 출고여부
FROM FOOD_ORDER
ORDER BY ORDER_ID ASC;

/*
 OUT_DATE가 NULL로 되어 있는 경우 출력에 빈칸이길래 그것도 CASE로 분류해줬더니 답이 아니라고 해서 머리가 아팠다.
 */