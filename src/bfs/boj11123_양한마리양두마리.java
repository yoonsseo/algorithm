package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj11123_양한마리양두마리 {
    /*
    flag를 두고 bfs에서 flag가 true로 바뀌면 count++을 해주었는데 틀림
    bfs 실행 조건에 visited뿐만 아니라 #인 경우 추가 했더니 맞음
     */
    static int H; // 높이
    static int W; // 너비
    static char[][] land;
    static boolean[][] visited;

    static int count;

    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken()); // 높이
            W = Integer.parseInt(st.nextToken()); // 너비

            land = new char[H][W];
            visited = new boolean[H][W];

            for (int j = 0; j < H; j++) {
                String l = br.readLine();
                for (int k = 0; k < W; k++) {
                    land[j][k] = l.charAt(k);
                }
            }

            count = 0;
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    if (!visited[j][k] && isSheep(j, k)) {
                        bfs(j, k);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = point.x + dx[i];
                int nextY = point.y + dy[i];

                if (rangeCheck(nextX, nextY) && !visited[nextX][nextY]) {
                    if (isSheep(nextX, nextY)) {
                        queue.offer(new Point(nextX, nextY));
                    }
                    visited[nextX][nextY] = true;
                }

            }
        }
    }

    private static boolean isSheep(int x, int y) {
        return (land[x][y] == '#');
    }

    private static boolean rangeCheck(int x, int y) {
        return (0 <= x && x < H && 0 <= y && y < W);
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
