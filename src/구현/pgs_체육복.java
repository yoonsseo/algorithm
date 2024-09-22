package 구현;

import java.util.Arrays;

public class pgs_체육복 {

    class Solution {
    /*
    n의 범위가 작아 상관없지만
    값을 비교해도 의미가 없는 경우 중단해주려고 했는데
    이 때 비교를 잘못 하는 바람에 오래 걸림..
    /*
    여벌 체육복이 있는 학생도 체육복을 도둑맞을 수 있다
    */

        public int solution(int n, int[] lost, int[] reserve) {
            // 일단 체육복을 도둑맞지 않은 학생들은 수업을 들을 수 있음
            int answer = n - lost.length;

            Arrays.sort(lost);
            Arrays.sort(reserve);

            // 도둑맞은 학생 중 여벌 체육복이 있는 학생
            for (int i = 0; i < lost.length; i++) {
                for (int j = 0; j < reserve.length; j++) {
                    int l = lost[i];
                    int r = reserve[j];

                    if (l < 0 || r < 0) {
                        continue;
                    }

                    if (l == r) {
                        answer++;
                        lost[i] = -2;
                        reserve[j] = -2;
                        break;
                    }

                    if (l < r) {
                        break;
                    }
                }
            }

            // 도둑맞은 학생 중 여벌 체육복이 없는 학생
            for (int i = 0; i < lost.length; i++) {
                for (int j = 0; j < reserve.length; j++) {
                    int l = lost[i];
                    int r = reserve[j];

                    if (l < 0) {
                        break;
                    }

                    if (r < 0) {
                        continue;
                    }

                    if (l == r - 1) {
                        answer++;
                        lost[i] = -2;
                        reserve[j] = -2;
                        break;
                    } else if (l == r + 1) {
                        answer++;
                        lost[i] = -2;
                        reserve[j] = -2;
                        break;
                    } else if (l < r + 1) {
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
