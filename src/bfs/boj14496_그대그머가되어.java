package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj14496_그대그머가되어 {
    /*
    문제만 읽고 알 수 없을 것 같은데 질문 게시판을 보니 양방향 연결이라고 함
    출발지와 목적지가 같은 경우를 고려했어야 함!
     */

    static int a;
    static int b;
    static int N;
    static int M;

    static List<Integer>[] arr;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        if (a == b) {
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[A].add(B);
            arr[B].add(A);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);
        dist[a] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : arr[now]) {
                if (dist[next] == Integer.MAX_VALUE) { // 방문한 적이 없다면
                    queue.offer(next);
                    dist[next] = dist[now] + 1;
                    if (next == b) {
                        System.out.println(dist[next]);
                        return;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}
