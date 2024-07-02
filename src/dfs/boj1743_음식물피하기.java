package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class boj1743_음식물피하기 {

    static int N; // 세로, 1부터
    static int M; // 가로, 1부터
    static int K; // 음식물 수, 1부터

    static int[][] food;
    static boolean[][] visited;

    static int count = 0;
    static int maxCount = 0;

    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        food = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            food[x][y] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!visited[i][j] && food[i][j] == 1) {
                    count = 1;
                    dfs(i, j);
                    if (maxCount < count) {
                        maxCount = count;
                    }
                }
            }
        }

        System.out.println(maxCount);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (rangeCheck(nextX, nextY) && !visited[nextX][nextY] && food[nextX][nextY] == 1) {
                count++;
                dfs(nextX, nextY);
            }
        }
        return;
    }

    static boolean rangeCheck(int x, int y) {
        return (1 <= x && x <= N && 1 <= y && y <= M);
    }

}
