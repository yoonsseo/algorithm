package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj21735_눈덩이굴리기 {
    /*
    처음에 dp로 생각했는데
    시간이 다 된 경우와 앞마당의 끝에 도달한 경우에 끝나기 때문에 dfs

    디버깅을 통해 이해
    혼자서는 못 풀었을 것 같다...ㅜ.ㅜ
     */
    static int N; // 앞마당 길이
    static int M; //대회의 시간
    static int[] snowflake; // 눈송이 크기 수열

    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        snowflake = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            snowflake[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 1);

        System.out.println(answer);
    }

    /*
        한 칸 이동하면 크기 더하기
        두 칸 이동하면 반으로 줄인 후(소수점 버림) 더하기
     */
    private static void dfs(int time, int loc, int snowball) {
        snowball += snowflake[loc];

        if (time == M || loc == N) {
            answer = Math.max(answer, snowball);
            return;
        }

        if (loc < N) {
            dfs(time + 1, loc + 1, snowball);
        }

        if (loc < N - 1) {
            dfs(time + 1, loc + 2, snowball / 2);
        }
    }
}
