SELECT JULY.FLAVOR
FROM FIRST_HALF AS FH, JULY
WHERE FH.FLAVOR = JULY.FLAVOR
GROUP BY JULY.FLAVOR
ORDER BY SUM(FH.TOTAL_ORDER + JULY.TOTAL_ORDER) DESC
LIMIT 3;