package bfs;

import java.util.*;

public class pgs_리코쳇로봇 {

    class Solution {
        static int N;
        static int M;

        static char[][] map;
        static int[][] visited; // 이동 횟수도 저장

        static Point start;
        static Point end;

        static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int solution(String[] board) {
            N = board.length;
            M = board[0].length();

            map = new char[N][M];
            for (int i = 0; i < N; i++) {
                String S = board[i];
                for (int j = 0; j < M; j++) {
                    map[i][j] = S.charAt(j);
                    if (map[i][j] == 'R') {
                        start = new Point(i, j);
                    } else if (map[i][j] == 'G') {
                        end = new Point(i, j);
                    }
                }
            }
            visited = new int[N][M];

            bfs();

            if (visited[end.x][end.y] == 0) {
                return -1;
            } else {
                return (visited[end.x][end.y] - 1);
            }
        }

        private void bfs() {
            Queue<Point> queue = new LinkedList<>();

            queue.offer(start);
            visited[start.x][start.y] = 1;

            while (!queue.isEmpty()) {
                Point now = queue.poll();

                if (isE(now.x, now.y)) {
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int x = now.x;
                    int y = now.y;
                    while (rangeCheck(x, y) && !isD(x, y)) {
                        x += d[i][0];
                        y += d[i][1];
                    }
                    x -= d[i][0];
                    y -= d[i][1];

                    if (visited[x][y] == 0) {
                        queue.offer(new Point(x, y));
                        visited[x][y] = visited[now.x][now.y] + 1;
                    }
                }
            }
        }

        private boolean isE(int x, int y) {
            return (x == end.x && y == end.y);
        }

        private boolean isD(int x, int y) {
            return map[x][y] == 'D';
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
