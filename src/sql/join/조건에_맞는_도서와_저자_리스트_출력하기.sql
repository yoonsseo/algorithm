SELECT B.BOOK_ID, A.AUTHOR_NAME,
       DATE_FORMAT(B.PUBLISHED_DATE, "%Y-%m-%d") AS pUBLISHED_DATE
FROM BOOK AS B, AUTHOR AS A
WHERE B.CATEGORY = "경제" AND B.AUTHOR_ID = A.AUTHOR_ID
ORDER BY PUBLISHED_DATE ASC;