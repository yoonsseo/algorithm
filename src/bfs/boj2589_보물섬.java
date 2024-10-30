package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2589_보물섬 {
    /*
    육지의 모든 위치에서 거리 구하기
    최단 거리 중 가장 긴 구간
     */
    static int N;
    static int M;

    static char[][] map;
    static boolean[][] visited;
    static int[][] dist;

    static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String string = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = string.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isLand(i, j)) {
                    dist = new int[N][M];
                    bfs(new Point(i, j));
                }
            }
        }

        max--;
        System.out.println(max);
    }

    private static void bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        dist[start.x][start.y] = 1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (rangeCheck(nx, ny) && isLand(nx, ny) && !visited(nx, ny)) {
                    dist[nx][ny] = dist[now.x][now.y] + 1;
                    max = Math.max(max, dist[nx][ny]);
                    queue.offer(new Point(nx, ny));
                }
            }
        }

    }

    private static boolean visited(int x, int y) {
        return dist[x][y] != 0;
    }

    private static boolean isLand(int x, int y) {
        return map[x][y] == 'L';
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
