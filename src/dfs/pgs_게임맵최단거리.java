package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pgs_게임맵최단거리 {
    /*
     하지만 dfs로 풀면 시간 초과
     최단 거리 문제는 보통 bfs로 푼다
     */
    static int N = 5;
    static int M = 5;
    static int[][] maps1 = new int[5][5];
    static int[][] maps2 = new int[5][5];

    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int answer = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                maps1[i][j] = Integer.parseInt(st.nextToken());
                maps2[i][j] = maps1[i][j];
            }
        }

        dfs(0, 0, 1);

        if (answer == 26) {
            answer = -1;
        }

        System.out.println(answer);
    }

    private static void dfs(int a, int b, int count) {
        System.out.print("dfs(" + a + ", " + b + ", " + count + ")\n");
        if (a == N - 1 && b == M - 1) {
            if (count < answer) {
                answer = count;
            }
            System.out.print("return dfs(" + a + ", " + b + ", " + count + ")\n");
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextA = a + dx[i];
            int nextB = b + dy[i];

            if (rangeCheck(nextA, nextB) && obstacleCheck(nextA, nextB)) {
                changeToObstacle(a, b);
                dfs(nextA, nextB, count + 1);
                backToOriginal(a, b);
            }
        }
    }

    private static void backToOriginal(int a, int b) {
        maps2[a][b] = maps1[a][b];
    }

    private static void changeToObstacle(int a, int b) {
        maps2[a][b] = 0;
    }

    private static boolean obstacleCheck(int a, int b) {
        return (maps2[a][b] == 1);
    }

    private static boolean rangeCheck(int a, int b) {
        return (0 <= a && a < N && 0 <= b && b < M);
    }


}
