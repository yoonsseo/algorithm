package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj17212_달나라토끼를위한구매대금지불도우미 {
    /*
    동전 종류는 1, 2, 5, 7
    P | 0 1 2 3 4 5 6 7  8 9 10
        0 1 1 2 2 1 2 1  2 2 3
    P(10) = P(7) + P(3) = 3
    P(11) = P(7) + P(4) = 3
    P(12) = P(7) + P(5) = 2
    P(13) = P(7) + P(6) = 3 = P(13 - 7) + 1
    P(14) = 2P(7) = 2 = P(7) + 1
    P(15) = 2P(7) + P(1) = 3 = P(15 - 1) + 1
    P(16) = 2P(7) + P(2) = 3 = P(16 - 2) + 1
    P(17) = P(14) + P(3) = 4
          = MIN[P(16), P(15), P(12), P(10)] + 1 = MIN[3, 3, 2, 3] + 1 = 3

    최소의 방법들을 구해두었다가
    1 동전 하나 또는 2 동전 하나 또는 5 동전 하나 또는 7 동전 하나를 추가하는 것이 최소
     */

    static int[] init = {0, 1, 1, 2, 2, 1, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N <= 7) {
            System.out.println(init[N]);
            return;
        }

        int[] dp = new int[N + 1];
        for (int i = 0; i <= 7; i++) {
            dp[i] = init[i];
        }

        for (int i = 8; i <= N; i++) {
            dp[i] = Math.min(Math.min(Math.min(dp[i - 1], dp[i - 2]), dp[i - 5]), dp[i - 7]) + 1;
        }

        System.out.println(dp[N]);
    }
}
