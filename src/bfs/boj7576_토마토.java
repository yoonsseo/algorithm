package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj7576_토마토 {
    static int N;
    static int M;

    static int[][] tomato;
    static int[][] visited;

    static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomato = new int[N][M];
        visited = new int[N][M];
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    queue.offer(new Point(i, j));
                    visited[i][j] = 1;
                } else if (tomato[i][j] == -1) {
                    visited[i][j] = -1;
                }
            }
        }

        int total = 0;
        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (rangeCheck(nx, ny) && visited[nx][ny] == 0 && isTomato(nx, ny)) {
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                    total = Math.max(visited[nx][ny], total);
                    queue.offer(new Point(nx, ny));
                }
            }
        }

        if (checkRiped()) {
            if (total - 1 < 0) {
                System.out.println(0);
            } else {
                System.out.println(total - 1);
            }
        } else {
            System.out.println(-1);
        }
    }

    private static boolean checkRiped() {
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    return false;
                }
            }
        }
        return flag;
    }

    private static boolean isTomato(int x, int y) {
        return tomato[x][y] == 0;
    }

    private static boolean rangeCheck(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < M);
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
