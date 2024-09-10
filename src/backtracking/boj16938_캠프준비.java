package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16938_캠프준비 {
    /*
    dfs에서 R < level이면 계속 탐색할 필요가 없다고 생각해서
    종료 조건을 아래와 같이 설정했었는데 테스트 케이스는 맞았지만 틀림

            if ((2 <= count && max - min < X) || R < level) {
            return;
        }

        if (L <= level && 2 <= count) {
            answer++;
        }

    반례
    4 10 20 5
    1 2 10 14
    1과 2를 먼저 선택하면 max - min = 2 - 1 = 1이므로 X = 5를 만족하지 않지만,
    나중에 10을 추가하면 난이도 차이가 10 - 1 = 9가 되면서 조건을 만족하게 된다
    그런데 원래 코드에서는 1과 2를 선택한 후 바로 탐색을 중단해버리므로,
    이후에 10을 추가할 기회를 잃게 됨
     */

    static int N; // 문제 개수
    static int L; // 난이도 합 최하
    static int R; // 난이도 합 최상
    static int X; // X <= 난이도 최상 - 난이도 최하

    static int[] A; // 문제별 난이도

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0, 1000009, 0);

        System.out.println(answer);
    }

    private static void dfs(int start, int level, int count, int min, int max) {
        if (R < level) {
            return;
        }

        if (L <= level && 2 <= count && X <= max - min) {
            answer++;
        }

        // 또는 아래와 같이
//        if (L <= level && level <= R && 2 <= count && X <= max - min) {
//            answer++;
//        }

        for (int i = start; i < N; i++) {
            dfs(i + 1, level + A[i], count + 1,
                    Math.min(min, A[i]), Math.max(max, A[i]));
        }

    }
}
