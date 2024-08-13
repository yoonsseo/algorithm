package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2644_촌수계산 {
    /*
    지난번 dfs로 풀었을 때는 테스트 케이스는 맞았지만 반례가 있었다
    촌수는 최단 거리처럼 최소의 촌수를 계산해야하기 때문에 bfs가 맞다고 생각했고 맞았당
     */
    static int n; // 사람 수
    static ArrayList<Integer>[] kinship; // 촌수
    static boolean[] visited;
    static int A; // 촌수를 계산해야 하는 사람1
    static int B; // 촌수를 계산해야 하는 사람 2
    static int[] count; // A와의 촌수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        kinship = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            kinship[i] = new ArrayList<Integer>();
        }
        visited = new boolean[n + 1];
        count = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 부모
            int y = Integer.parseInt(st.nextToken()); // 자식
            kinship[x].add(y);
            kinship[y].add(x);
        }

        bfs();

        if (count[B] == 0) { // 촌수를 계산할 수 없다면
            System.out.println(-1);
        } else {
            System.out.println(count[B]);
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(A);
        visited[A] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : kinship[now]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    count[next] = count[now] + 1;
                }
            }
        }
    }
}
