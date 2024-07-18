package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj26170_사과빨리먹기 {
    /*
    백트래킹 + dfs
    노드 방문 전후로 visited값 바꿔주기

    1이면 사과, 0이면 빈 칸, -1이면 장애물
    학생이 지나간 칸은 장애물로 변한다

    다시 돌아왔을 때 원래의 사과밭으로 돌아와야한다!
    사과가 있었으면 1로 돌아와야 한다!
     */

    static int[][] orchard = new int[5][5]; // 원본 사과밭
    static int[][] visited = new int[5][5]; // 학생이 이동 시 바뀌는 사과밭
    static int x; // 현재 위치
    static int y; // 현재 위치

    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int minMove = 25; // 이동 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                orchard[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = orchard[i][j];
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        dfs(x, y, 0, 0);

        if (minMove == 25) {
            System.out.println(-1);
        } else {
            System.out.println(minMove);

        }
    }

    private static void dfs(int a, int b, int apple, int move) {
        if (orchard[a][b] == 1) {
            apple++;
        }

        if (apple == 3) {
            if (move < minMove) {
                minMove = move;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextA = a + dx[i];
            int nextB = b + dy[i];

            if (rangeCheck(nextA, nextB) && obstacleCheck(nextA, nextB)) {
                changeToObstacle(a, b);
                dfs(nextA, nextB, apple, move + 1);
                backToOriginal(a, b);
            }
        }
    }

    private static void backToOriginal(int a, int b) { // 다시 돌아왔을 때 원본으로 변경
        visited[a][b] = orchard[a][b];
    }

    private static void changeToObstacle(int a, int b) { // 지나간 길 장애물 -1로 변경
        visited[a][b] = -1;
    }

    private static boolean obstacleCheck(int a, int b) {
        return (visited[a][b] != -1);
    }

    private static boolean rangeCheck(int a, int b) {
        return (0 <= a && a < 5 && 0 <= b && b < 5);
    }
}
