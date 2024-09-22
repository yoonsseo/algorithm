package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2169_로봇조종하기 {
    /*
    (1,0)에 가는 법
    (0,0) -> (1,0) 로 바로 갈 수 있지만
    (0,0) -> (0,1) -> (0,2) -> ... -> (0,n) -> (1,n) -> (1,n-1) -> ... -> (1,1) -> (1,0)
    빙 돌아갈 수 있음!!
     */

    static int N, M;
    static int[][] map, dp;

    static int[][] temp;
    /*
    temp = new int[2][M] 으로
    0행은 위쪽값과 왼쪽값의 합
    1행은 위쪽값과 오른쪽값의 합을 저장해
    최종적으로 dp에 Math.max(temp[0][j], temp[1][j]) 값을 저장하도록 한다
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];
        temp = new int[2][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = map[0][0];
        for (int j = 1; j < M; j++) {
            dp[0][j] = dp[0][j-1] + map[0][j];
        }

        for (int i = 1; i < N; i++) {
            // 위쪽값과 왼쪽값의 합 (오른쪽으로의 합)
            temp[0][0] = dp[i-1][0] + map[i][0];
            for (int j = 1; j < M; j++) {
                temp[0][j] = Math.max(dp[i - 1][j], temp[0][j - 1]) + map[i][j];
            }

            // 위쪽값과 오른쪽값의 합 (왼쪽으로의 합)
            temp[1][M - 1] = dp[i - 1][M - 1] + map[i][M - 1];
            for (int j = M - 2; 0 <= j; j--) {
                temp[1][j] = Math.max(dp[i - 1][j], temp[1][j + 1]) + map[i][j];
            }

            // 최종 최댓값
            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }

        System.out.println(dp[N - 1][M - 1]);

    }
}
