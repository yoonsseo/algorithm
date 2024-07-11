/*
 보호소에서 중성화 수술을 거친 동물 정보를 알아보려 합니다.
 보호소에 들어올 당시에는 중성화되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물의
 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회하는 SQL 문을 작성해주세요.

 중성화를 거치지 않은 동물은 성별 및 중성화 여부에 Intact,
 중성화를 거친 동물은 Spayed 또는 Neutered라고 표시되어있습니다.
 */

SELECT AI.ANIMAL_ID, AI.ANIMAL_TYPE, AI.NAME
FROM ANIMAL_INS AS AI
         JOIN ANIMAL_OUTS AS AO ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE AI.SEX_UPON_INTAKE LIKE "Intact%"
  AND (AO.SEX_UPON_OUTCOME LIKE "Spayed%"
    OR AO.SEX_UPON_OUTCOME LIKE "Neutered%")
ORDER BY AI.ANIMAL_ID ASC
;
-- OR절에 괄호