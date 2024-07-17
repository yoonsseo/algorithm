package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj26169_세번이내에사과를먹자 {
    /*
    1이면 사과, 0이면 빈 칸, -1이면 장애물
    학생이 지나간 칸은 장애물로 변한다

    세 번 이하의 이동으로 사과를 2개 이상 먹을 수 있으면 1 출력, 그렇지 않으면 0 출력
     */
    static int[][] orchard = new int[5][5];

    static int x; // 현재 위치
    static int y; // 현재 위치

    static int move = 0; // 이동 횟수
    static int answer = 0;

    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                orchard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        dfs(x, y, 0);

        System.out.println(answer);
    }

    private static void dfs(int a, int b, int apple) {
        if (orchard[a][b] == 1) {
            apple++;
        }

        if (move == 3) {
            if (2 <= apple) {
                answer = 1;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = a + dx[i];
            int nextY = b + dy[i];

            if (rangeCheck(nextX, nextY) && obstacleCheck(nextX, nextY)) { // 범위 이내이면, 장애물이 아니면
                move++;
                changeObstacle(a, b);
                dfs(nextX, nextY, apple);
                changeObstacle(a, b);
                move--;
            }
        }
    }

    private static void changeObstacle(int a, int b) {
        if (orchard[a][b] == -1) {
            orchard[a][b] = 0;
        } else {
            orchard[a][b] = -1;
        }
    }

    private static boolean obstacleCheck(int a, int b) {
        return (orchard[a][b] != -1);
    }

    private static boolean rangeCheck(int a, int b) {
        return (0 <= a && a < 5 && 0 <= b && b < 5);
    }
}
