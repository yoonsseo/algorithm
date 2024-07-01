package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class boj1926_그림 {
    static int N; // 세로
    static int M; // 가로

    static int count = 0; // 그림 개수
    static int width = 0; // 그림 넓이
    static int maxWidth = 0; // 최대 넓이

    static int[][] drawing;
    static boolean[][] visited;

    // 상 하 좌 우
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        drawing = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                drawing[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && drawing[i][j] == 1) {
                    width = 1;
                    dfs(i, j);
                    count++;
                    if (maxWidth < width) {
                        maxWidth = width;
                    }
                }
            }
        }

        System.out.println(count + "\n" + maxWidth);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (rangeCheck(nextX, nextY) && !visited[nextX][nextY] && drawing[nextX][nextY] == 1) {
                width++;
                dfs(nextX, nextY);
            }
        }
        return;
    }

    static boolean rangeCheck(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < M);
    }
}
