package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj3085_사탕게임 {
    /*
    완전 탐색
     */
    static int N; // 보드의 크기

    static char[][] original; // 원래 사탕 색상
    static char[][] colour; // 바뀐 사탕 색상

    static int[] d = {-1, 1};

    static int max = 0;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        original = new char[N][N];
        colour = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                // 색상은 C, P, Z, Y
                original[i][j] = line.charAt(j);
                colour[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                // 좌우 변경
                swap(i, j, i, j + 1);
                maxRow();
                maxCol();
                swap(i, j, i, j + 1);

                // 상하 변경
                swap(j, i, j + 1, i);
                maxRow();
                maxCol();
                swap(j, i, j + 1, i);
            }
        }

        System.out.println(max);
    }

    private static void swap(int a1, int b1, int a2, int b2) {
        char c = colour[a1][b1];
        colour[a1][b1] = colour[a2][b2];
        colour[a2][b2] = c;
    }

    // 수가 작아서 그냥 전부 탐색
    private static void maxRow() {
        for (int i = 0; i < N; i++) {
            count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (colour[i][j] == colour[i][j + 1]) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }
    }

    private static void maxCol() {
        for (int i = 0; i < N; i++) {
            count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (colour[j][i] == colour[j + 1][i]) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }
    }
}
