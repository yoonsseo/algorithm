package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1652_누울자리를찾아라 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[][] room = new String[N][N];
        int row = 0;
        int col = 0;
        int count;

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            count = 0;
            for (int j = 0; j < N; j++) {
                room[i][j] = split[j];
                if (split[j].equals(".")) {
                    count++;
                } else {
                    if (2 <= count) {
                        row++;
                    }
                    count = 0;
                }

                if (j == N - 1 && 2 <= count) {
                    row++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            count = 0;
            for (int j = 0; j < N; j++) {
                if (room[j][i].equals(".")) {
                    count++;
                } else {
                    if (2 <= count) {
                        col++;
                    }
                    count = 0;
                }

                if (j == N - 1 && 2 <= count) {
                    col++;
                }
            }
        }

        System.out.println(row + " " + col);
    }
}
