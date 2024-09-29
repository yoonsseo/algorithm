package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1916_최소비용구하기 {
    static int N; // 도시 개수, 1부터
    static int M; // 버스 개수, 1부터

    static ArrayList<Node>[] graph;

    static int A; // 출발 도시 번호
    static int B; // 도착 도시 번호

    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[S].add(new Node(E, C));
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dijkstra();

        // 반드시 도착하는 경우만 주어지나?
        System.out.println(dist[B]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pQueue = new PriorityQueue<>();

        pQueue.offer(new Node(A, 0));
        dist[A] = 0;

        while (!pQueue.isEmpty()) {
            Node now = pQueue.poll();

            if (!visited[now.vertex]) { // 방문한 적이 없으면
                visited[now.vertex] = true;

                for (Node next : graph[now.vertex]) {
                    int newCost = dist[now.vertex] + next.cost;
                    if (newCost < dist[next.vertex]) {
                        dist[next.vertex] = newCost;
                        pQueue.offer(new Node(next.vertex, newCost));
                    }
                }
            }
        }

    }

    public static class Node implements Comparable<Node> {
        int vertex;
        int cost;

        public Node(int v, int c) {
            this.vertex = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

}
