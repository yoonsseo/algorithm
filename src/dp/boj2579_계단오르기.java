package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2579_계단오르기 {
    // dp는 점화식/공식/규칙을 찾아야 하는데 이게 어려운 부분!

    static int N; // 계단 수
    static int[] score;
    static int[] dp; // 점수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        score = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
        }

        /* 초기 설정을 이렇게 해두었는데 그러면 계단이 1개이면 에러!
        dp[1] = score[1];
        dp[2] = dp[1] + score[2];
        */

        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                dp[1] = score[1];
            } else if (i == 2) {
                dp[2] = dp[1] + score[2];
            } else {
                dp[i] = Math.max(dp[i - 3] + score[i - 1], dp[i - 2]) + score[i];
            }
        }

        System.out.println(dp[N]);
    }
}
