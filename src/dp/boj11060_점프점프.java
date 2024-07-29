package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11060_점프점프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        Arrays.fill(dp, N + 2);
        dp[1] = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= arr[i]; j++) {
                if (i + j <= N) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }

        if (dp[N] != N + 2) {
            System.out.println(dp[N]);
        } else {
            System.out.println(-1);
        }
    }
}
