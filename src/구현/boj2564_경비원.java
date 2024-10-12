package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2564_경비원 {
    static int N;
    static int M;

    static int T;

    static int[][] market;

    static int[] guard = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        T = Integer.parseInt(br.readLine());
        market = new int[T][2];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            // 1북쪽, 2남쪽, 3서쪽, 4동쪽
            int d = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            market[i][0] = d; // 방향
            market[i][1] = l; // 거리
        }

        st = new StringTokenizer(br.readLine());
        guard[0] = Integer.parseInt(st.nextToken());
        guard[1] = Integer.parseInt(st.nextToken());

        int total = 0;
        for (int i = 0; i < T; i++) {
            int sum = 0;

            int d = market[i][0];
            int l = market[i][1];

            int diff = Math.abs(d - guard[0]);
            if (diff == 0) {
                sum = Math.abs(l - guard[1]);
            } else if (diff == 1) { // 2남과 3서
                if (d == 2 && guard[0] == 3) {
                    sum = N - guard[1] + l;
                } else if (d == 3 && guard[0] == 2) {
                    sum = N - l + guard[1];
                } else if (d == 1 || d == 2) {
                    // 시계 or 반시계
                    sum = Math.min(N + l + guard[1], N + (M - guard[1]) + (M - l));
                } else {
                    // 시계 or 반시계
                    sum = Math.min(M + guard[1] + l, M + (N - l) + (N - guard[1]));
                }
            } else if (diff == 2) {
                if (d == 1 || d == 3) {
                    sum = guard[1] + l;
                } else { // d == 2 || d == 4
                    sum = N - l + M - guard[1];
                }
            } else if (diff == 3) { // 1북과 4동
                if (d == 1) {
                    sum = guard[1]+ M - l;
                } else {
                    sum = l + M - guard[1];
                }
            }

            total += sum;
        }

        System.out.println(total);
    }
}
