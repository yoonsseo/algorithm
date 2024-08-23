package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj31418_스펀지 {
    /*
    범위 int가 아니라 long으로 설정이 중요,,

    이동 가능한 칸의 개수만 세면 된다
     */
    static long W;
    static long H;
    static int K; // 바이러스 수
    static long T; // 관찰 시간

    static int[][] virus;
    static long[] range;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Long.parseLong(st.nextToken());
        H = Long.parseLong(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        T = Long.parseLong(st.nextToken());

        virus = new int[K][2];
        range = new long[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            virus[i][1] = Integer.parseInt(st.nextToken());
            virus[i][0] = Integer.parseInt(st.nextToken());
        }

        long total = 1;
        for (int i = 0; i < K; i++) {
            long a = virus[i][0];
            long b = virus[i][1];
            long rangeA = (Math.min(a + T, H) - Math.max(a - T, 1) + 1) % 998244353;
            long rangeB = (Math.min(b + T, W) - Math.max(b - T, 1) + 1) % 998244353;
            range[i] = (rangeA * rangeB) % 998244353;
            total = (total * range[i]) % 998244353;
        }
        System.out.println(total);
    }
}
