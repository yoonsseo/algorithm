package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj17025_icyperimeter {
    static int N;

    static char[][] ice;
    static boolean[][] visited;

    static int maxArea = 0;
    // 면적이 같을 경우 더 작은 둘레
    static int minPeri = Integer.MAX_VALUE;

    static int area;
    static int peri;

    static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ice = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                ice[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && isIce(i, j)) {
                    area = 0;
                    peri = 0;
                    bfs(i, j);
                    if (maxArea < area) {
                        maxArea = area;
                        minPeri = peri;
                    } else if (maxArea == area) {
                        minPeri = Math.min(minPeri, peri);
                    }
                }
            }
        }

        System.out.println(maxArea + " " + minPeri);
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            area++;
            peri += calcPeri(now.x, now.y);

            for (int i = 0; i < 4; i++) {
                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (rangeCheck(nx, ny) && isIce(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }
        }


    }

    private static int calcPeri(int x, int y) {
        int calc = 0;

        if (isCorner(x, y)) {
            calc += 2;
        } else if (isEdge(x, y)) {
            calc += 1;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + d[i][0];
            int ny = y + d[i][1];

            if (rangeCheck(nx, ny) && !isIce(nx, ny)) {
                calc += 1;
            }
        }

        return calc;
    }

    private static boolean isCorner(int x, int y) {
        return ((x == 0 && y == 0) || (x == 0 && y == N - 1) ||
                (x == N - 1 && y == 0) || (x == N - 1 && y == N - 1));
    }

    private static boolean isEdge(int x, int y) {
        return (x == 0 || x == N - 1 || y == 0 || y == N - 1);
    }

    private static boolean isIce(int x, int y) {
        return ice[x][y] == '#';
    }

    private static boolean rangeCheck(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this. x = x;
            this.y = y;
        }
    }
}
