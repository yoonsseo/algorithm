package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1303_전쟁전투 {
    /**
     * M이 세로, N이 가로이고
     * 가로 크기 N, 세로 크기 M 순으로 입력받는데
     * 문제를 주의 깊게 읽지 않아서 틀렸다
     */

    static int M; // 세로
    static int N; // 가로

    static String[][] field;
    static boolean[][] visited;

    static int troopW = 0; // 우리 병력
    static int troopB = 0; // 상대 병력

    static int count;

    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        field = new String[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for (int j = 0; j < N; j++) {
                field[i][j] = String.valueOf(input.charAt(j));
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count = 1;
                    dfs(i, j);
                    if (field[i][j].equals("W")) {
                        troopW += (int) Math.pow(count, 2);
                    } else {
                        troopB += (int) Math.pow(count, 2);
                    }
                }
            }
        }

        System.out.println(troopW + " " + troopB);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (rangeCheck(nextX, nextY) && !visited[nextX][nextY] && field[nextX][nextY].equals(field[x][y])) {
                count++;
                dfs(nextX, nextY);
            }
        }
    }

    static boolean rangeCheck(int x, int y) {
        return (0 <= x && x < M && 0 <= y && y < N);
    }
}
