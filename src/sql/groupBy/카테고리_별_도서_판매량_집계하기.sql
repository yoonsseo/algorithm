/*
 다음은 어느 한 서점에서 판매중인 도서들의 도서 정보(BOOK), 판매 정보(BOOK_SALES) 테이블입니다.

BOOK 테이블 BOOK_ID, CATEGORY, AUTHOR_ID, PRICE, PUBLISHED_DATE 는
 도서 ID, 카테고리 (경제, 인문, 소설, 생활, 기술), 저자 ID, 판매가 (원), 출판일 을 나타냅니다.

BOOK_SALES 테이블 BOOK_ID, SALES_DATE, SALES 는
 도서 ID, 판매일, 판매량 을 나타냅니다.

2022년 1월의 카테고리 별 도서 판매량을 합산하고, 카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 리스트를 출력하는 SQL문을 작성해주세요.
결과는 카테고리명을 기준으로 오름차순 정렬해주세요.
 */

SELECT B.CATEGORY AS CATEGORY, SUM(BS.SALES) AS TOTAL_SALES
FROM BOOK AS B
         JOIN BOOK_SALES AS BS
              ON B.BOOK_ID = BS.BOOK_ID
WHERE BS.SALES_DATE LIKE "2022-01%"
GROUP BY B.CATEGORY
ORDER BY B.CATEGORY ASC;