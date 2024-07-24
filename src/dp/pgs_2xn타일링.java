package dp;

public class pgs_2xn타일링 {
    class Solution {
        public int solution(int n) {
            int answer = 0;

            int[] dp = new int[n + 2]; // 2 * idx 까지 경우의 수
            dp[1] = 1;
            dp[2] = 2;

            if (2 < n) {
                for (int i = 3; i <= n; i++) {
                    dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
                }
            }

            answer = dp[n];

            return answer;
        }
    }
}
