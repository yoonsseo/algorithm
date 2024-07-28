package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1309_동물원 {
    static int[] init = {0, 3, 7};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N <= 2) {
            System.out.println(init[N]);
            return;
        }

        int[] dp = new int[N + 1];
        for (int i = 1; i < 3; i++) {
            dp[i] = init[i];
        }
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] * 3 + (dp[i - 1] - dp[i - 2]) * 2) % 9901;
        }
        System.out.println(dp[N]);
    }
}
