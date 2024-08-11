package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj2178_미로탐색 {
    static int N; // 세로
    static int M; // 가로

    static int[][] maze;
    static int[][] distance;
    // visited를 따로 두지 않고 distance를 -1로 초기화하여 방문 여부 확인
    static Queue<Point> queue = new LinkedList<>();

    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        distance = new int[N][M];

        for (int i = 0; i < N; i++) { // 미로 입력
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Character.getNumericValue(input.charAt(j));
                distance[i][j] = -1;
            }
        }

        queue.offer(new Point(0, 0));
        distance[0][0] = 1;

        while (!queue.isEmpty()) { // 큐가 비어있지 않으면
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = point.getX() + dx[i];
                int nextY = point.getY() + dy[i];

                if (rangeCheck(nextX, nextY) && obstacleCheck(nextX, nextY) && distance[nextX][nextY] == -1) {
                    queue.offer(new Point(nextX, nextY));
                    distance[nextX][nextY] = distance[point.getX()][point.getY()] + 1;
                }
            }
        }

        System.out.println(distance[N - 1][M - 1]);
    }

    public static boolean obstacleCheck(int x, int y) {
        return maze[x][y] == 1;
    }

    public static boolean rangeCheck(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < M);
    }

    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
