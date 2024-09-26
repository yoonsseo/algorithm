package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj5972_택배배송 {

    static int N; // 노드 수, 1부터
    static int M; // 엣지 수

    static ArrayList<Node>[] graph; // 거리 저장

    static boolean[] visited;
    static int[] dist; // 여물

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
//        Arrays.fill(graph, new ArrayList<>());
// 이렇게 선언하면 하나의 객체가 선언되어 graph[0], graph[1], ... 모두 같은 객체를 같게 된다
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }

        dijkstra();

        // 무조건 도착할 수 있는 경우만 주어지나?
        System.out.println(dist[N]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pQueue = new PriorityQueue<>();

        pQueue.offer(new Node(1, 0));
        dist[1] = 0;

        while (!pQueue.isEmpty()) {
            Node now = pQueue.poll();

            if (!visited[now.vertex]) {
                visited[now.vertex] = true;

                for (Node next : graph[now.vertex]) {
                    int newDist = dist[now.vertex] + next.cost;
                    if (newDist < dist[next.vertex]) {
                        dist[next.vertex] = newDist;
                        // 여기에서 next를 넣는 게 아니라 거리합을 갱신해서 새로운 노드로 넣어주어야 함!
                        pQueue.offer(new Node(next.vertex, newDist));
                    }
                }
            }
        }

    }

    static class Node implements Comparable<Node> {
        private int vertex;
        private int cost;

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
