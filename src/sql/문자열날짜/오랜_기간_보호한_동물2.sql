/*
 ANIMAL_INS 테이블 ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는
 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.

 ANIMAL_OUTS 테이블 ANIMAL_ID, ANIMAL_TYPE, DATETIME, NAME, SEX_UPON_OUTCOME는
 각각 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부를 나타냅니다.
 ANIMAL_OUTS 테이블의 ANIMAL_ID는 ANIMAL_INS의 ANIMAL_ID의 외래 키입니다.

 입양을 간 동물 중, 보호 기간이 가장 길었던 동물 두 마리의 아이디와 이름을 조회하는 SQL문을 작성해주세요.
 이때 결과는 보호 기간이 긴 순으로 조회해야 합니다.
 */

SELECT I.ANIMAL_ID, I.NAME
FROM ANIMAL_INS AS I
         JOIN ANIMAL_OUTS AS O
              ON I.ANIMAL_ID = O.ANIMAL_ID
ORDER BY (O.DATETIME-I.DATETIME) DESC
LIMIT 2;