package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj20493_세상은하나의손수건 {
    static String[] d = {"R", "D", "L", "U"};
    static int idxD = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int time = 0;
    static int nextTime = 0;
    static String direction = "R";

    static int x = 0;
    static int y = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        if (N == 0) {
            x += T;
        } else {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                nextTime = Integer.parseInt(st.nextToken());
                direction = st.nextToken();

                x += ((nextTime - time) * dx[idxD]);
                y += ((nextTime - time) * dy[idxD]);
                idxD = setIdxD(direction);
                time = nextTime;
            }
            x += ((T - time) * dx[idxD]);
            y += ((T - time) * dy[idxD]);
        }

        System.out.println(x + " " + y);
    }

    static int setIdxD(String direction) {
        if (idxD == 0 && direction.equals("left")) {
            idxD = 3;
        } else if (idxD == 3 && direction.equals("right")) {
            idxD = 0;
        } else if (direction.equals("left")) {
            idxD--;
        } else { // direction.equals("right")
            idxD++;
        }

        return idxD;
    }
}
