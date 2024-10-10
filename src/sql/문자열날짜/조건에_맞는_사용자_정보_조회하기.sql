/*
 USED_GOODS_BOARD 테이블 BOARD_ID, WRITER_ID, TITLE, CONTENTS, PRICE, CREATED_DATE, STATUS, VIEWS는
 게시글 ID, 작성자 ID, 게시글 제목, 게시글 내용, 가격, 작성일, 거래상태, 조회수를 의미합니다.

 USED_GOODS_USER 테이블 USER_ID, NICKNAME, CITY, STREET_ADDRESS1, STREET_ADDRESS2, TLNO는
 각각 회원 ID, 닉네임, 시, 도로명 주소, 상세 주소, 전화번호를 의미합니다.

 USED_GOODS_BOARD와 USED_GOODS_USER 테이블에서
 중고 거래 게시물을 3건 이상 등록한 사용자의
 사용자 ID, 닉네임, 전체주소, 전화번호를 조회하는 SQL문을 작성해주세요.
 이때, 전체 주소는 시, 도로명 주소, 상세 주소가 함께 출력되도록 해주시고,
 전화번호의 경우 xxx-xxxx-xxxx 같은 형태로 하이픈 문자열(-)을 삽입하여 출력해주세요.
 결과는 회원 ID를 기준으로 내림차순 정렬해주세요.
 */

SELECT B.WRITER_ID, U.NICKNAME, CONCAT(U.CITY, " ", U.STREET_ADDRESS1, " ", U.STREET_ADDRESS2) AS 전체주소,
       CONCAT(SUBSTRING(U.TLNO, 1, 3), "-", SUBSTRING(U.TLNO, 4, 4), "-", SUBSTRING(U.TLNO, 8, 4)) AS 전화번호
FROM USED_GOODS_BOARD AS B
         JOIN USED_GOODS_USER AS U
              ON B.WRITER_ID = U.USER_ID
GROUP BY B.WRITER_ID
HAVING COUNT(B.BOARD_ID) >= 3
ORDER BY U.USER_ID DESC;