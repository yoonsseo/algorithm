package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2606_바이러스 {
    // 인접 리스트로 그래프 구현 + dfs

    static ArrayList<Integer>[] link;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 컴퓨터 수
        link = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            link[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 연결쌍 수
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            link[a].add(b);
            link[b].add(a);
            // 반대로도 연결해주어야 한다!
        }

        dfs(1);

        System.out.println(count);
    }

    static void dfs(int now) {
        visited[now] = true;
        for (int i = 0; i < link[now].size(); i++) {
            int next = link[now].get(i);
            if (!visited[next]) { // 방문하지 않았으면
                dfs(next);
                count++;
            }
        }
    }
}
