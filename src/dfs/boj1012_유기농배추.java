package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1012_유기농배추 {
    static int M; // 가로
    static int N; // 세로

    static int[][] A;
    static boolean[][] visited;

    // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 테스트케이스 개수
        for (int k = 0; k < T; k++) { // 테스트케이스 반복
            int count = 0;

            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            int K = Integer.parseInt(st.nextToken()); // 배추 개수

            A = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++) { // 배추 위치 입력
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                A[X][Y] = 1;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (A[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println();
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(A[i][j]);
                }
                System.out.println();
            }
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(visited[i][j]);
                }
                System.out.println();
            }
            System.out.println(count);
        }
    }

    public static void dfs(int x, int y) {
        if (visited[x][y]) { // 이미 방문
            return;
        } else {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int tmpx = x + dx[i];
                int tmpy = y + dy[i];

                if (rangeCheck(tmpx, tmpy) && A[tmpx][tmpy] == 1) {
                    dfs(tmpx, tmpy);
                }
            }
        }
    }

    public static boolean rangeCheck(int x, int y) {
        return (0 <= x && x < M && 0 <= y && y < N);
    }
}
