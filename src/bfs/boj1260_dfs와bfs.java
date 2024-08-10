package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj1260_dfs와bfs {
    /*
    dfs에서 인접리스트를 사용하는 경우 추가적인 정렬이 필요
    크기가 크지 않기 때문에 인접 행렬 사용
     */
    static int N; // 정점의 개수
    static int M; // 간선의 개수
    static int V; // 탐색을 시작할 정점의 번호

    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        // dfs
        dfs(V);
        sb.append("\n");

        // bfs
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start);
        sb.append(" ");

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[start][i] == 1) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        visited[start] = true;
        queue.offer(start);
        sb.append(start);
        sb.append(" ");

        while (!queue.isEmpty()) { // 큐가 비어있지 않다면
            int peek = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && graph[peek][i] == 1) {// 아직 방문하지 않았고 연결되어 있음
                    visited[i] = true;
                    queue.offer(i);
                    sb.append(i);
                    sb.append(" ");
                }
            }
        }
    }
}
