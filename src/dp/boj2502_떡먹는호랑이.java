package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2502_떡먹는호랑이 {
    /*
    P(1) = A + 0B
    P(2) = 0A + B
    P(3) = A + B
    P(4) = A + 2B
    P(5) = 2A + 3B
    P(6) = 3A + 5B
    P(7) = 5A + 8B
    P(8) = 8A + 11B
    P(9) = 13A + 19B
    P(10) = 21A + 30B
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[D + 1];
        A[1] = 1;
        A[2] = 0;

        int[] B = new int[D + 1];
        B[1] = 0;
        B[2] = 1;

        for (int i = 3; i <= D; i++) {
            A[i] = A[i - 2] + A[i - 1];
            B[i] = B[i - 2] + B[i - 1];
        }

        int a = 1;
        while (true) {
            int R = K - (A[D] * a);
            if (R % B[D] == 0) {
                int b = R / B[D];
                System.out.println(a + "\n" + b);
                return;
            }
            a++;
        }
    }
}
