package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2961_도영이가만든맛있는음식 {
    /*
    중간에 선택하지 않은 경우 고려했어야
     */
    static int N;

    static int[][] ingredient;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ingredient = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            bt(ingredient[i][0], ingredient[i][1], i + 1);
        }

        System.out.println(min);
    }

    private static void bt(int sour, int bitter, int idx) {
        min = Math.min(min, Math.abs(sour - bitter));

        for (int i = idx; i < N; i++) {
            bt(sour, bitter, i + 1); // 비선택
            bt(sour * ingredient[i][0], bitter + ingredient[i][1], i + 1); // 선택
        }
    }
}
