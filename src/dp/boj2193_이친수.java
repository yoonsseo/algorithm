package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2193_이친수 {
    /*
    처음에 걱정했던대로 int범위를 넘어 long으로 수정
    근데 어떻게 알지,,ㅜㅜ
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        long[] zero = new long[N + 1];
        zero[1] = 0;

        long[] one = new long[N + 1];
        one[1] = 1;

        for (int i = 2; i <= N; i++) {
            zero[i] = zero[i - 1] + one[i - 1];
            one[i] = zero[i - 1];
        }

        long answer = zero[N] + one[N];
        System.out.println(answer);
    }
}
