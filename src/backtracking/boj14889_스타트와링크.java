package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14889_스타트와링크 {
    /*
    비선택인 경우를 제거하고 0을 무조건 스타트 팀에 포함시키면 조금 더 효율적이게 됨
    스타트팀과 링크팀의 능력치를 계산하는 함수를 각각 만들었는데
    하나의 함수에서 계산하고 차이값을 반환해 for문 반복도 줄이기
     */
    static int N;

    static int[][] S;

    static boolean[] visited;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;
        bt(1, 1);

        System.out.println(min);
    }

    private static void bt(int idx, int count) {
        if (count == N / 2) {
            min = Math.min(min, calcDiff());
            return;
        }

        for (int i = idx; i < N; i++) {
            visited[i] = true;
            bt(i + 1, count + 1);
            visited[i] = false;
        }
    }

    private static int calcDiff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start += S[i][j] + S[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += S[i][j] + S[j][i];
                }
            }
        }
        return Math.abs(start - link);
    }
}
