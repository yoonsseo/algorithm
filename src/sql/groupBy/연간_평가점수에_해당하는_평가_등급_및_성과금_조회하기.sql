/*
 문제 설명
HR_DEPARTMENT 테이블은 회사의 부서 정보를 담은 테이블입니다.
 HR_DEPARTMENT 테이블의 구조는 다음과 같으며 DEPT_ID, DEPT_NAME_KR, DEPT_NAME_EN, LOCATION은
 각각 부서 ID, 국문 부서명, 영문 부서명, 부서 위치를 의미합니다.

Column name	Type	Nullable
DEPT_ID	VARCHAR	FALSE
DEPT_NAME_KR	VARCHAR	FALSE
DEPT_NAME_EN	VARCHAR	FALSE
LOCATION	VARCHAR	FLASE

HR_EMPLOYEES 테이블은 회사의 사원 정보를 담은 테이블입니다.
 HR_EMPLOYEES 테이블의 구조는 다음과 같으며 EMP_NO, EMP_NAME, DEPT_ID, POSITION, EMAIL, COMP_TEL, HIRE_DATE, SAL은
 각각 사번, 성명, 부서 ID, 직책, 이메일, 전화번호, 입사일, 연봉을 의미합니다.

Column name	Type	Nullable
EMP_NO	VARCHAR	FALSE
EMP_NAME	VARCHAR	FALSE
DEPT_ID	VARCHAR	FALSE
POSITION	VARCHAR	FALSE
EMAIL	VARCHAR	FALSE
COMP_TEL	VARCHAR	FALSE
HIRE_DATE	DATE	FALSE
SAL	NUMBER	FALSE

HR_GRADE 테이블은 2022년 사원의 평가 정보를 담은 테이블입니다.
 HR_GRADE의 구조는 다음과 같으며 EMP_NO, YEAR, HALF_YEAR, SCORE는
 각각 사번, 연도, 반기, 평가 점수를 의미합니다.

Column name	Type	Nullable
EMP_NO	VARCHAR	FALSE
YEAR	NUMBER	FALSE
HALF_YEAR	NUMBER	FALSE
SCORE	NUMBER	FALSE

문제
HR_DEPARTMENT, HR_EMPLOYEES, HR_GRADE 테이블을 이용해 사원별 성과금 정보를 조회하려합니다.
 평가 점수별 등급과 등급에 따른 성과금 정보가 아래와 같을 때,
 사번, 성명, 평가 등급, 성과금을 조회하는 SQL문을 작성해주세요.

평가등급의 컬럼명은 GRADE로, 성과금의 컬럼명은 BONUS로 해주세요.
결과는 사번 기준으로 오름차순 정렬해주세요.

기준 점수	평가 등급	성과금(연봉 기준)
96 이상	S	20%
90 이상	A	15%
80 이상	B	10%
이외	C	0%
 */

--  문제에 안적혀있지만 평균 점수로 계산 -> 대체 왜 이 중요한 조건이 문제에 나와있지 않은 건지 도무지 이해할 수가 없다
SELECT E.EMP_NO, E.EMP_NAME,
       (CASE
            WHEN AVG(G.SCORE) >= 96 THEN "S"
            WHEN AVG(G.SCORE) >= 90 THEN "A"
            WHEN AVG(G.SCORE) >= 80 THEN "B"
            ELSE "C"
           END) AS GRADE,
       (CASE
            WHEN AVG(G.SCORE) >= 96 THEN E.SAL * 0.2
            WHEN AVG(G.SCORE) >= 90 THEN E.SAL * 0.15
            WHEN AVG(G.SCORE) >= 80 THEN E.SAL * 0.1
            ELSE 0
           END) AS BONUS
FROM HR_EMPLOYEES AS E
         JOIN HR_GRADE AS G
              ON E.EMP_NO = G.EMP_NO
GROUP BY E.EMP_NO
ORDER BY E.EMP_NO ASC;