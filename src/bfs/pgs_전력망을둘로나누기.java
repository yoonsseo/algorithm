package bfs;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class pgs_전력망을둘로나누기 {

    class Solution { // bfs 풀이
        static ArrayList<Integer>[] graph;
        static boolean[] visited;

        public int solution(int n, int[][] wires) {
            int answer = n;

            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < wires.length; i++) {
                int a = wires[i][0];
                int b = wires[i][1];
                graph[a].add(b);
                graph[b].add(a);
            }

            for (int i = 0; i < wires.length; i++) {
                int a = wires[i][0];
                int b = wires[i][1];
                graph[a].remove(Integer.valueOf(b));
                graph[b].remove(Integer.valueOf(a));

                visited = new boolean[n + 1];
                int count = bfs(1); // 한 전력망의 송전탑 개수
                int diff = Math.abs((n - count) - count); // 두 전력망의 송전탑 개수 차 절대값

                answer = Math.min(answer, diff);

                graph[a].add(b);
                graph[b].add(a);
            }

            return answer;
        }

        private int bfs(int S) { // 시작 노드
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(S);
            visited[S] = true;

            int count = 1;
            while (!queue.isEmpty()) {
                int node = queue.poll();

                for (int next : graph[node]) {
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                        count++;
                    }
                }
            }

            return count;
        }
    }
}
