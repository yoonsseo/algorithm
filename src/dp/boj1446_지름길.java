package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1446_지름길 {
    /*
    지름길 시작위치를 기준으로 정렬하고
    거리가 갱신되면
    그 이후의 거리도 갱신되도록 했는데 그렇게 하면 왜 안 될까
     */

    static int N; // 지름길 개수
    static int D; // 고속도로 길이

    static int[] dist;
    static int[][] shortcut;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dist = new int[D + 1];
        for (int i = 0; i < D + 1; i++) {
            dist[i] = i;
        }

        shortcut = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (e <= D) {
                shortcut[i][0] = s;
                shortcut[i][1] = e;
                shortcut[i][2] = d;
            } else {
                shortcut[i][0] = -1;
            }
        }

        for (int i = 0; i < D; i++) {
            dist[i + 1] = Math.min(dist[i + 1], dist[i] + 1);

            for (int j = 0; j < N; j++) {
                int s = shortcut[j][0];
                if (s == i) {
                    int e = shortcut[j][1];
                    int d = shortcut[j][2];
                    int temp = dist[s] + d;
                    dist[e] = Math.min(dist[e], temp);
                }
            }
        }

        System.out.println(dist[D]);
    }
}
