/*
 FISH_INFO 테이블 ID, FISH_TYPE, LENGTH, TIME은
 각각 잡은 물고기의 ID, 물고기의 종류(숫자), 잡은 물고기의 길이(cm), 물고기를 잡은 날짜를 나타냅니다.

 FISH_NAME_INFO 테이블은 물고기의 이름에 대한 정보를 담고 있습니다.
FISH_TYPE, FISH_NAME 은 각각 물고기의 종류(숫자), 물고기의 이름(문자) 입니다.

 물고기 종류 별로 가장 큰 물고기의 ID, 물고기 이름, 길이를 출력하는 SQL 문을 작성해주세요.
물고기의 ID 컬럼명은 ID, 이름 컬럼명은 FISH_NAME, 길이 컬럼명은 LENGTH로 해주세요.
결과는 물고기의 ID에 대해 오름차순 정렬해주세요.
단, 물고기 종류별 가장 큰 물고기는 1마리만 있으며 10cm 이하의 물고기가 가장 큰 경우는 없습니다.
 */

SELECT FI.ID, FNI.FISH_NAME, FI.LENGTH
FROM FISH_INFO AS FI
         JOIN FISH_NAME_INFO AS FNI ON FI.FISH_TYPE = FNI.FISH_TYPE
WHERE FI.LENGTH IS NOT NULL
  AND FI.LENGTH = (SELECT MAX(LENGTH) FROM FISH_INFO WHERE FISH_TYPE = FI.FISH_TYPE) -- 또는 FNI.FISH_TYPE 도 가능
ORDER BY FI.ID ASC
;
/*
FISH_INFO 테이블에서 FISH_TYPE이 FI.FISH_TYPE과 같은 모든 행을 선택합니다.
이 선택된 행들 중에서 LENGTH 열의 최대 값을 찾습니다 (MAX(LENGTH)).
이 최대값을 FI.LENGTH와 비교하여, FI.LENGTH가 이 값과 같은지 확인합니다.
 */


/*
 SELECT FI.ID, FNI.FISH_NAME, FI.LENGTH
FROM FISH_INFO AS FI
    JOIN FISH_NAME_INFO AS FNI ON FI.FISH_TYPE = FNI.FISH_TYPE
WHERE FI.LENGTH IS NOT NULL
GROUP BY FI.FISH_TYPE
    HAVING MAX(FI.LENGTH)
ORDER BY FI.ID ASC
;
 */
/*
 실패 (1055, "Expression #1 of SELECT list is not in GROUP BY clause
 and contains nonaggregated column 'programmers.FI.ID'
 which is not functionally dependent on columns in GROUP BY clause;
 this is incompatible with sql_mode=only_full_group_by")
 */
/*
 GROUP BY절이 있는데
 GROUP BY절에 사용되지 않은 FI.ID, FNI.FISH_NAME, FI.LENGTH 컬럼이
 집계함수를 사용하지 않은 채 (EX. MAX(FI.LENGTH))
 SELECT절에 사용되었기 때문에 나는 오류
 */
/*

 */