package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14891_톱니바퀴 {
    /*
    톱니를 회전시키기 전 기준으로 NS 확인
     */
    static int[][] wheel = new int[5][8];
    static int K; //회전수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 4; i++) {
            String status = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = Integer.parseInt(String.valueOf(status.charAt(j)));
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 톱니 번호
            int dir = Integer.parseInt(st.nextToken()); // 회전 방향, 1이면 시계, -1이면 반시계
            int rev = dir == 1 ? -1 : 1;

            /*
             톱니1의 [2]-톱니2의 [6] | 톱니2의 [2] - 톱니3의 [6] ..
             */
            if (w == 1) {
                if (wheel[1][2] != wheel[2][6]) {
                    if (wheel[2][2] != wheel[3][6]) {
                        if (wheel[3][2] != wheel[4][6]) {
                            rearrange(4, rev);
                        }
                        rearrange(3, dir);
                    }
                    rearrange(2, rev);
                }
            } else if (w == 4) {
                if (wheel[4][6] != wheel[3][2]) {
                    if (wheel[3][6] != wheel[2][2]) {
                        if (wheel[2][6] != wheel[1][2]) {
                            rearrange(1, rev);
                        }
                        rearrange(2, dir);
                    }
                    rearrange(3, rev);
                }
            } else if (w == 2) {
                if (wheel[2][6] != wheel[1][2]) {
                    rearrange(1, rev);
                }
                if (wheel[2][2] != wheel[3][6]) {
                    if (wheel[3][2] != wheel[4][6]) {
                        rearrange(4, dir);
                    }
                    rearrange(3, rev);
                }
            } else if (w == 3) {
                if (wheel[3][2] != wheel[4][6]) {
                    rearrange(4, rev);
                }
                if (wheel[3][6] != wheel[2][2]) {
                    if (wheel[2][6] != wheel[1][2]) {
                        rearrange(1, dir);
                    }
                    rearrange(2, rev);
                }
            }

            rearrange(w, dir);
        }

        /*
         N극은 0, S극은 1
         1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
         2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
         3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
         4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점
         */
        int total = 0;
        total += wheel[1][0] == 0 ? 0 : 1;
        total += wheel[2][0] == 0 ? 0 : 2;
        total += wheel[3][0] == 0 ? 0 : 4;
        total += wheel[4][0] == 0 ? 0 : 8;

        System.out.println(total);
    }

    private static void rearrange(int w, int dir) {
        int temp = 0;

        if (dir == 1) { // 시계 방향
            temp = wheel[w][7];
            for (int i = 7; 1 <= i; i--) {
                wheel[w][i] = wheel[w][i - 1];
            }
            wheel[w][0] = temp;
        } else { //반시계방향
            temp = wheel[w][0];
            for (int i = 0; i <= 6; i++) {
                wheel[w][i] = wheel[w][i + 1];
            }
            wheel[w][7] = temp;
        }
    }
}
