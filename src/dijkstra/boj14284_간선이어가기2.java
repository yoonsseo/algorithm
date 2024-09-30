package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj14284_간선이어가기2 {
    static int N; // 정점 수
    static int M; // 간선 수

    static int S;
    static int T;

    static boolean[] visited;
    static int[] dist;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        dist = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        dijkstra();

        System.out.println(dist[T]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pQueue = new PriorityQueue<>();

        pQueue.offer(new Node(S, 0));
        dist[S] = 0;

        while (!pQueue.isEmpty()) {
            Node now = pQueue.poll();

            if (!visited[now.vertex]) {
                visited[now.vertex] = true;

                for (Node next : graph[now.vertex]) {
                    int newDist = next.cost + dist[now.vertex];
                    if (newDist < dist[next.vertex]) {
                        dist[next.vertex] = newDist;
                        pQueue.offer(new Node(next.vertex, newDist));
                    }
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
        public int vertex;
        public int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }



}
