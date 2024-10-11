package bfs;

import java.util.*;

public class pga_무인도여행 {

    class Solution {
        static int N;
        static int M;

        static int[][] map;
        static boolean[][] visited;

        static List<Integer> foodList = new ArrayList<>();

        static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int[] solution(String[] maps) {
            N = maps.length;
            M = maps[0].length();

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                String S = maps[i];
                for (int j = 0; j < M; j++) {
                    char c = S.charAt(j);
                    if (c == 'X') {
                        map[i][j] = 0;
                    } else {
                        map[i][j] = Integer.parseInt(String.valueOf(c));
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j]) {
                        if (isLand(i, j)) {
                            bfs(i, j);
                        } else {
                            visited[i][j] = true;
                        }
                    }
                }
            }

            if (foodList.size() == 0) {
                return new int[]{-1};
            }

            Collections.sort(foodList);
            int[] answer = new int[foodList.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = foodList.get(i);
            }

            return answer;
        }

        private void bfs(int x, int y) {
            Queue<Point> queue = new LinkedList<>();
            int food = map[x][y];

            queue.offer(new Point(x, y));
            visited[x][y] = true;

            while (!queue.isEmpty()) {
                Point now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nextX = now.x + d[i][0];
                    int nextY = now.y + d[i][1];

                    if (rangeCheck(nextX, nextY) && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;

                        if (isLand(nextX, nextY)) {
                            food += map[nextX][nextY];
                            queue.offer(new Point(nextX, nextY));
                        }
                    }
                }
            }

            foodList.add(food);
        }

        private boolean isLand(int x, int y) {
            return map[x][y] != 0;
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
