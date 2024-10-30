package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj13549_숨바꼭질3 {
    /*
    N이 K보다 클 수도!

    순간이동이 시간이 더 적게 걸리기 때문에 먼저 처리
     */
    static int N;
    static int K;

    static int B;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        B = Math.max(N, K);
        visited = new int[B * 2 + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        dijkstra();

        System.out.println(visited[K]);
    }

    private static void dijkstra() {
        PriorityQueue<Point> pQueue = new PriorityQueue<>();
        pQueue.offer(new Point(N, 0));
        visited[N] = 0;

        while (!pQueue.isEmpty()) {
            Point now = pQueue.poll();
            if (now.x == K) {
                break;
            }

            // *2 순간이동
            int next = now.x * 2;
            if (rangeCheck(next)) {
                if (visited[now.x] < visited[next]) {
                    visited[next] = visited[now.x];
                    pQueue.offer(new Point(next, visited[next]));
                }
            }

            // +1
            next = now.x + 1;
            if (rangeCheck(next)) {
                if (visited[now.x] + 1 < visited[next]) {
                    visited[next] = visited[now.x] + 1;
                    pQueue.offer(new Point(next, visited[next]));
                }
            }

            // -1
            next = now.x - 1;
            if (rangeCheck(next) && visited[next] == Integer.MAX_VALUE) {
                if (visited[now.x] + 1 < visited[next]) {
                    visited[next] = visited[now.x] + 1;
                    pQueue.offer(new Point(next, visited[next]));
                }
            }
        }

    }

    private static boolean rangeCheck(int x) {
        return (0 <= x && x <= B * 2);
    }

    private static class Point implements Comparable<Point> {
        int x;
        int t;

        public Point(int x, int t) {
            this.x = x;
            this.t = t;
        }

        @Override
        public int compareTo(Point point) {
            return this.t - point.t;
        }

    }
}
