package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj15652_N과M4 {
    /*
    StringBuilder를 이용해 모든 재귀가 끝나고 마지막에 딱 한 번만 출력
     */
    static int N; // 1부터 N까지
    static int M; // 중복해서 M개 -> visited가 필요없음

    static int[] num;

    static int count = 0;
    static List<Integer> perm = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        num = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            num[i] = i;
        }
        M = Integer.parseInt(st.nextToken());

        dfs(1);

        System.out.println(sb);
    }

    private static void dfs(int now) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(perm.get(i));
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = now; i <= N; i++) {
            perm.add(i);
            count++;
            dfs(i);
            count--;
            perm.remove(perm.size() - 1);
        }
    }
}
