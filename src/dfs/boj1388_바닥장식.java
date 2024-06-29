package dfs;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1388_바닥장식 {

    static int N; // 세로
    static int M; // 가로

    static String[][] floor;
    static boolean[][] visited;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        floor = new String[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for (int j = 0; j < M; j++) {
                floor[i][j] = String.valueOf(input.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(int a, int b) {
        visited[a][b] = true;
        if (floor[a][b].equals("|")) { // 세로바닥
            if ((a + 1) < N && !visited[a + 1][b] && floor[a + 1][b].equals("|")) {
                dfs(a + 1, b);
            } else {
                return;
            }
        } else { // 가로바닥 -
            if ((b + 1) < M && !visited[a][b + 1] && floor[a][b + 1].equals("-")) {
                dfs(a, b + 1);
            } else {
                return;
            }
        }

    }
}