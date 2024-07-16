package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj15650_N과M2 {
    static int N; // 1부터 N까지
    static int M; // 중복없이 M개

    static int[] num;
    static boolean[] visited;

    static int count = 0;
    static List<Integer> perm = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        num = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            num[i] = i;
        }
        visited = new boolean[N + 1];
        M = Integer.parseInt(st.nextToken());

        dfs(1);
    }

    private static void dfs(int now) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(perm.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = now; i <= N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            perm.add(i);
            count++;
            dfs(i + 1);
            count--;
            perm.remove(perm.size() - 1);
            visited[i] = false;
        }
    }
}
