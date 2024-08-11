package bfs;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class pgs_게임맵최단거리 {
    class Solution {
        static int[][] maze;
        static int N;
        static int M;

        // 상 하 좌 우
        static int[] dx = {-1, 1, 0, 0};
        static int[] dy = {0, 0, -1, 1};

        public int solution(int[][] maps) {
            int answer = 0;
            maze = maps.clone();

            N = maps.length; // 세로 길이
            M = maps[0].length; // 가로 길이
            System.out.println("N = " + N + " M = " + M);

            int[][] distance = new int[N][M];
            for (int[] d : distance) {
                Arrays.fill(d, -1);
            }

            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(0, 0));
            distance[0][0] = 1;

            while (!queue.isEmpty()) {
                Point point = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nextX = point.getX() + dx[i];
                    int nextY = point.getY() + dy[i];

                    if (rangeCheck(nextX, nextY) && obstacleCheck(nextX, nextY)
                            && distance[nextX][nextY] == -1) {
                        queue.offer(new Point(nextX, nextY));
                        distance[nextX][nextY] = distance[point.getX()][point.getY()] + 1;
                    }
                }
            }

            if (distance[N - 1][M - 1] == -1) { // 도착하지 못한다면
                answer = -1;
            } else {
                answer = distance[N - 1][M - 1];
            }

            return answer;
        }

        public boolean obstacleCheck(int x, int y) {
            return (maze[x][y] == 1);
        }

        public boolean rangeCheck(int x, int y) {
            return (0 <= x && x < N && 0 <= y && y < M);
        }

        public class Point {
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
}
