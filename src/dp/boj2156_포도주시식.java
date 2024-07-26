package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2156_포도주시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] wine = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
            dp[i] = wine[i];
        }

        if (N == 1) {
            System.out.println(dp[0]);
            return;
        }

        dp[1] = wine[0] + wine[1];
        if (N == 2) {
            System.out.println(dp[1]);
            return;
        }

        dp[2] = Math.max(Math.max(dp[1], (dp[0] + wine[2])), (wine[1] + wine[2]));
        if (N == 3) {
            System.out.println(dp[2]);
            return;
        }

        int answer = 0;
        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + wine[i - 1], dp[i - 2]) + wine[i]);
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
