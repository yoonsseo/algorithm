package backtracking;

public class pgs_피로도 {

    class Solution {
        static int N;
        static int answer = 0;
        static boolean[] visited;
        static int[][] D;

        public int solution(int k, int[][] dungeons) {
            N = dungeons.length;
            visited = new boolean[N];
            D = dungeons.clone();

            dfs(k, 0);

            return answer;
        }

        private void dfs(int k, int count) {
            answer = Math.max(answer, count);

            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    if (D[i][0] <= k) {
                        visited[i] = true;
                        dfs(k - D[i][1], count + 1);
                        visited[i] = false;
                    }
                }
            }
        }
    }
}
