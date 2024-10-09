package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj15683_감시 {
    static int N;
    static int M;

    static int[][] map;
    static boolean[][] visited;
    static boolean[][] visible;

    static List<Point> cctv = new ArrayList<>();
    static List<Point> wall = new ArrayList<>();

    static int min = 65;

    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상 우 하 좌

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        visible = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= map[i][j] && map[i][j] <= 5) {
                    cctv.add(new Point(i, j, map[i][j]));
                } else if (map[i][j] == 6) {
                    wall.add(new Point(i, j, map[i][j]));
                }
            }
        }

        dfs(0, map);

        System.out.println(min);
    }

    private static void dfs(int idx, int[][] cMap) {
        if (idx == cctv.size()) {
            min = Math.min(min, countInvisible(cMap));
            return;
        }

        Point now = cctv.get(idx);
        if (now.type == 1) { // 상 우 하 좌
            for (int i = 0; i < 4; i++) {
                int[][] newMap = copyMap(cMap);
                int nextX = now.x;
                int nextY = now.y;
                while (true) {
                    nextX += dir[i][0];
                    nextY += dir[i][1];
                    if (!rangeCheck(nextX, nextY) || isWall(nextX, nextY)) {
                        break;
                    } else {
                        newMap[nextX][nextY] = -1;
                    }
                }
                dfs(idx + 1, newMap);
            }
        } else if (now.type == 2) { // 상하02 좌우13
            for (int i = 0; i < 2; i++) {
                int[][] newMap = copyMap(cMap);
                int x1 = now.x;
                int y1 = now.y;
                while (true) {
                    x1 += dir[i][0];
                    y1 += dir[i][1];
                    if (!rangeCheck(x1, y1) || isWall(x1, y1)) {
                        break;
                    } else {
                        newMap[x1][y1] = -1;
                    }
                }
                int x2 = now.x;
                int y2 = now.y;
                while (true) {
                    x2 += dir[i + 2][0];
                    y2 += dir[i + 2][1];
                    if (!rangeCheck(x2, y2) || isWall(x2, y2)) {
                        break;
                    } else {
                        newMap[x2][y2] = -1;
                    }
                }
                dfs(idx + 1, newMap);
            }
        } else if (now.type == 3) { // 상우01 우하12 하좌23 좌상34(=0)
            for (int i = 0; i < 4; i++) {
                int[][] newMap = copyMap(cMap);
                int x1 = now.x;
                int y1 = now.y;
                while (true) {
                    x1 += dir[i][0];
                    y1 += dir[i][1];
                    if (!rangeCheck(x1, y1) || isWall(x1, y1)) {
                        break;
                    } else {
                        newMap[x1][y1] = -1;
                    }
                }
                int x2 = now.x;
                int y2 = now.y;
                while (true) {
                    x2 += dir[(i + 1) % 4][0];
                    y2 += dir[(i + 1) % 4][1];
                    if (!rangeCheck(x2, y2) || isWall(x2, y2)) {
                        break;
                    } else {
                        newMap[x2][y2] = -1;
                    }
                }
                dfs(idx + 1, newMap);
            }
        } else if (now.type == 4) { // 상우하012 우하좌123 하좌상230 좌상우301
            for (int i = 0; i < 4; i++) {
                int[][] newMap = copyMap(cMap);
                int x1 = now.x;
                int y1 = now.y;
                while (true) {
                    x1 += dir[i][0];
                    y1 += dir[i][1];
                    if (!rangeCheck(x1, y1) || isWall(x1, y1)) {
                        break;
                    } else {
                        newMap[x1][y1] = -1;
                    }
                }
                int x2 = now.x;
                int y2 = now.y;
                while (true) {
                    x2 += dir[(i + 1) % 4][0];
                    y2 += dir[(i + 1) % 4][1];
                    if (!rangeCheck(x2, y2) || isWall(x2, y2)) {
                        break;
                    } else {
                        newMap[x2][y2] = -1;
                    }
                }
                int x3 = now.x;
                int y3 = now.y;
                while (true) {
                    x3 += dir[(i + 2) % 4][0];
                    y3 += dir[(i + 2) % 4][1];
                    if (!rangeCheck(x3, y3) || isWall(x3, y3)) {
                        break;
                    } else {
                        newMap[x3][y3] = -1;
                    }
                }
                dfs(idx + 1, newMap);
            }

        } else { // now.type == 5
            int[][] newMap = copyMap(cMap);
            for (int i = 0; i < 4; i++) {
                int nextX = now.x;
                int nextY = now.y;
                while (true) {
                    nextX += dir[i][0];
                    nextY += dir[i][1];
                    if (!rangeCheck(nextX, nextY) || isWall(nextX, nextY)) {
                        break;
                    } else {
                        newMap[nextX][nextY] = -1;
                    }
                }
            }
            dfs(idx + 1, newMap);
        }

    }

    private static int[][] copyMap(int[][] originalMap) {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = originalMap[i][j];
            }
        }
        return newMap;
    }

    private static int countInvisible(int[][] cMap) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cMap[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isWall(int x, int y) {
        return map[x][y] == 6;
    }

    private static boolean rangeCheck(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < M);
    }

    private static class Point {
        int x;
        int y;
        int type;

        public Point(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
