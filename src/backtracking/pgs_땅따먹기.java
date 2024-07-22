package backtracking;

public class pgs_땅따먹기 {
    /*
    dfs로 풀면 4의 10만제곱으로 시간 초과!!!
    dp로 풀어야한다
     */
    class Solution {
        static int[][] land2;
        static int answer = 0;

        int solution(int[][] land) {
            land2 = land.clone();

            dfs(0, -1, 0);

            return answer;
        }

        void dfs(int row, int prevCol, int sum) {
            if (row == land2.length) {
                if (answer < sum) {
                    answer = sum;
                }
                return;
            }

            for (int j = 0; j < 4; j++) {
                if (j != prevCol) {
                    dfs(row + 1, j, sum + land2[row][j]);
                }
            }
        }
    }
}
