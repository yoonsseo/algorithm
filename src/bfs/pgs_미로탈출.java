package bfs;

import java.util.*;

public class pgs_미로탈출 {

    class Solution {
        static int N;
        static int M;

        static Point start;
        static Point lever;
        static Point exit;

        static char[][] map;
        static boolean[][] visited;
        static int[][] distance;

        static boolean leverFound;
        static boolean exitFound;

        // 상 하 좌 우
        static int[] dx = {-1, 1, 0, 0};
        static int[] dy = {0, 0, -1, 1};

        public int solution(String[] maps) {
            int answer = -1;

            N = maps.length;
            M = maps[0].length();

            map = new char[N][M];
            for (int i = 0; i < N; i++) {
                String m = maps[i];
                for (int j = 0; j < M; j++) {
                    map[i][j] = m.charAt(j);

                    if (map[i][j] == 'S') {
                        start = new Point(i, j);
                    } else if (map[i][j] == 'L') {
                        lever = new Point(i, j);
                    } else if (map[i][j] == 'E') {
                        exit = new Point(i, j);
                    }
                }
            }
            distance = new int[N][M];

            bfsToL();
            if (!leverFound) {
                return -1;
            }

            bfsToE();
            if (!exitFound) {
                return -1;
            }

            return distance[exit.x][exit.y];
        }

        private void bfsToL() {
            Queue<Point> queue = new LinkedList<>();
            visited = new boolean[N][M];

            queue.offer(new Point(start.x, start.y));

            while (!queue.isEmpty() && !leverFound) {
                Point now = queue.poll();

                if (!visited[now.x][now.y]) {
                    visited[now.x][now.y] = true;

                    for (int i = 0; i < 4; i++) {
                        int nextX = now.x + dx[i];
                        int nextY = now.y + dy[i];

                        if (rangeCheck(nextX, nextY) && !visited[nextX][nextY] && isRoad(nextX, nextY)) {
                            distance[nextX][nextY] = distance[now.x][now.y] + 1;
                            queue.offer(new Point(nextX, nextY));
                            if (isLever(nextX, nextY)) {
                                leverFound = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        private void bfsToE() {
            Queue<Point> queue = new LinkedList<>();
            visited = new boolean[N][M];

            queue.offer(new Point(lever.x, lever.y));

            while (!queue.isEmpty() && !exitFound) {
                Point now = queue.poll();

                if (!visited[now.x][now.y]) {
                    visited[now.x][now.y] = true;

                    for (int i = 0; i < 4; i++) {
                        int nextX = now.x + dx[i];
                        int nextY = now.y + dy[i];

                        if (rangeCheck(nextX, nextY) && !visited[nextX][nextY] && isRoad(nextX, nextY)) {
                            distance[nextX][nextY] = distance[now.x][now.y] + 1;
                            queue.offer(new Point(nextX, nextY));
                            if (isExit(nextX, nextY)) {
                                exitFound = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        private boolean isRoad(int x, int y) {
            return map[x][y] != 'X';
        }

        private boolean isLever(int x, int y) {
            return map[x][y] == 'L';
        }

        private boolean isExit(int x, int y) {
            return map[x][y] == 'E';
        }

        private boolean rangeCheck(int x, int y) {
            return (0 <= x && x < N && 0 <= y && y < M);
        }

        private class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
