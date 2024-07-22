package dp;

public class pgs_땅따먹기 {
    /*
    dfs로 풀면 4의 10만제곱으로 시간 초과!!!
    dp로 풀어야한다
     */
    class Solution {
        int solution(int[][] land) {
            int answer = 0;

            for (int i = 1; i < land.length; i++) {
                land[i][0] += Math.max(Math.max(land[i - 1][1], land[i - 1][2]), land[i - 1][3]);
                land[i][1] += Math.max(Math.max(land[i - 1][0], land[i - 1][2]), land[i - 1][3]);
                land[i][2] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][3]);
                land[i][3] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][2]);
            }

            int sum = 0;
            for (int i = 0; i < 4; i++) {
                sum = land[land.length - 1][i];
                if (answer < sum) {
                    answer = sum;
                }
            }

            return answer;
        }


    }
}
