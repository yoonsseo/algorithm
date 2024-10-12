package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14719_빗물 {
    static int H;
    static int W;

    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        B = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 1; i < W - 1; i++) {
            int left = B[i];
            for (int j = i - 1; 0 <= j; j--) {
                left = Math.max(left, B[j]);
            }
            int right = B[i];
            for (int j = i + 1; j < W; j++) {
                right = Math.max(right, B[j]);
            }

            answer += Math.min(left, right) - B[i];
        }

        System.out.println(answer);
    }
}
