package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14940_쉬운최단거리 {
    /*
    원래 갈 수 없는 땅인 위치는 0을 출력하고,
    원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치는 -1을 출력한다.
     */
    static int N; // 세로 크기
    static int M; // 가로 크기

    //0은 갈 수 없는 땅이고 1은 갈 수 있는 땅, 2는 목표지점
    static int[][] map;
    static int[][] distance;

    static int A; // 세로 목표 지점 좌표
    static int B; // 가로 목표 지점 좌표

    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        distance = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int m = Integer.parseInt(st.nextToken());
                map[i][j] = m;
                if (m == 2) {
                    A = i;
                    B = j;
                    distance[i][j] = 0;
                }
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(A, B));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = point.x + dx[i];
                int nextY = point.y + dy[i];

                if (rangeCheck(nextX, nextY) && available(nextX, nextY) && !visited(nextX, nextY)) {
                    queue.offer(new Point(nextX, nextY));
                    distance[nextX][nextY] = distance[point.x][point.y] + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (available(i, j) && !visited(i, j)) { // 접근 가능하지만 도달할 수 없는 부분
                    sb.append(-1);
                    sb.append(" ");
                } else {
                    sb.append(distance[i][j]);
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean visited(int x, int y) { // 방문한 적 없으면 false 반환
        return !(distance[x][y] == 0);
    }

    private static boolean available(int x, int y) {
        return (map[x][y] == 1);
    }

    private static boolean rangeCheck(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < M);
    }

    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
