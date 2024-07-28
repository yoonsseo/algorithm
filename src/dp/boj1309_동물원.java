package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1309_동물원 {
    /*
    dp[i]를 구할 때

    dp[i - 1]번째 줄에 사자가 없으면
    i번째 줄에 사자가 없거나, 왼쪽 칸에 있거나 오른쪽 칸에 있거나 3가지 경우

    dp[i - 1]번째 줄에 사자가 있으면
    i번째 줄에 사자가 없거나, 사자가 i - 1 번째 줄에 있는 사자와 다른 칸에 있는 2가지 경우
     */
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
