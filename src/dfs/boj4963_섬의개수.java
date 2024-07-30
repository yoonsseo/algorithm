package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj4963_섬의개수 {
    static int w; // 너비 가로
    static int h; // 높이 세로

    static int island = 0;

    static boolean flag = false; // 탐색 시 섬이 있는지 여부

    static int[][] map; // 1은 땅, 0은 바다
    static boolean[][] visited;

    // N NE E SE S SW W NW
    static int[] dh = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dw = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        while (w != 0 && h != 0) {
            map = new int[h][w];
            visited = new boolean[h][w];
            island = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j]) {
                        if (map[i][j] == 1) {
                            flag = true;
                        }
                        dfs(i, j);
                        if (flag) {
                            island++;
                            flag = false;
                        }
                    }
                }
            }

            System.out.println(island);

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }
    }

    static void dfs(int a, int b) {
        visited[a][b] = true;

        for (int i = 0; i < 8; i++) {
            int nextA = a + dh[i];
            int nextB = b + dw[i];

            if (rangeCheck(nextA, nextB) && !visited[nextA][nextB]) {
                if (isSea(nextA, nextB)) {
                    visited[nextA][nextB] = true;
                } else {
                    flag = true;
                    dfs(nextA, nextB);
                }
            }
        }
    }

    static boolean isSea(int a, int b) { // 1은 땅, 0은 바다
        return (map[a][b] == 0);
    }

    static boolean rangeCheck(int a, int b) {
        return (0 <= a && a < h && 0 <= b && b < w);
    }
}

