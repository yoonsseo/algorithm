package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj9461_파도반수열 {
    /*
    답이 int를 넘어갈 수 있음!!

    P(1)부터 P(10)까지 첫 10개 숫자는
    1, 1, 1, 2, 2, 3, 4, 5, 7, 9
    P(11) = P(6) + P(10) = 3 + 9 = 12
    P(12) = P(7) + P(11) = 4 + 12 = 16
    P(13) = P(8) + P(12) = 5 + 16 = 21
    P(14) = P(9) + P(13) = 7 + 21 = 28
     */
    static int[] init = {0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9};

    static List<Long> P = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i <= 10; i++) {
            P.add((long) init[i]);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            if (N < P.size()) {
                System.out.println(P.get(N));
            } else {
                while (P.size() <= N) {
                    int idx = P.size();
                    P.add(P.get(idx - 5) + P.get(idx - 1));
                }
                System.out.println(P.get(N));
            }
        }
    }
}
