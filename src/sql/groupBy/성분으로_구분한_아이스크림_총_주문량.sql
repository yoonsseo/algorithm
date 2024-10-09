/*
  FIRST_HALF 테이블 SHIPMENT_ID, FLAVOR, TOTAL_ORDER 는
  각각 출하 번호, 아이스크림 맛, 상반기 아이스크림 총주문량을 나타냅니다.
  FIRST_HALF 테이블의 기본 키는 FLAVOR입니다.

  ICECREAM_INFO 테이블 FLAVOR, INGREDITENT_TYPE 은
  각각 아이스크림 맛, 아이스크림의 성분 타입을 나타냅니다.
  ICECREAM_INFO의 기본 키는 FLAVOR입니다.

  ICECREAM_INFO테이블의 FLAVOR는 FIRST_HALF 테이블의 FLAVOR의 외래 키입니다.

  상반기 동안 각 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총주문량을 총주문량이 작은 순서대로 조회하는 SQL 문을 작성해주세요.
  이때 총주문량을 나타내는 컬럼명은 TOTAL_ORDER로 지정해주세요.
 */

SELECT II.INGREDIENT_TYPE, SUM(FH.TOTAL_ORDER)
FROM FIRST_HALF AS FH
         JOIN ICECREAM_INFO AS II
              ON II.FLAVOR = FH.FLAVOR
GROUP BY II.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER ASC;