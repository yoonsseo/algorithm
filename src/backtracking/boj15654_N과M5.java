package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class boj15654_N과M5 {
    static int N; // 1부터 N까지 자연수
    static int M; // M개 선택

    static int[] num;
    static boolean[] visited; // 중복은 안 됨
    static List<Integer> perm = new ArrayList<>(); // 순서가 다르면 다르다
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        visited = new boolean[N];

        dfs();

        System.out.println(sb);
    }

    public static void dfs() {
        if (count == M) {
            for (int i = 0; i < perm.size(); i++) {
                sb.append(perm.get(i));
                sb.append(" ");
            }
            sb.append("\n");
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm.add(num[i]);
                count++;
                dfs();
                count--;
                perm.remove(perm.size() - 1);
                visited[i] = false;
            }
        }


    }
}
