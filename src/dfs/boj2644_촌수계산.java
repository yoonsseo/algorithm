package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2644_촌수계산 {
    static int n; // 사람 수
    static ArrayList<Integer>[] kinship; // 촌수
    static boolean[] visited;
    static int a; // 촌수를 계산해야 하는 사람1
    static int b; // 촌수를 계산해야 하는 사람 2
    static int count = 0; // a와 b의 촌수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        kinship = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            kinship[i] = new ArrayList<Integer>();
        }
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 부모
            int y = Integer.parseInt(st.nextToken()); // 자식
            kinship[x].add(y);
            kinship[y].add(x);
        }

        for (int i = 1; i < kinship.length; i++) {
            System.out.print("[" + i + "] ");
            for (int j = 0; j < kinship[i].size(); j++) {
                System.out.print(kinship[i].get(j) + " ");
            }
            System.out.println();
        }

        dfs(a, b);

        if (!visited[b]) {
            System.out.println(-1);
            return;
        }
        System.out.println(count);
    }

    private static void dfs(int w, int z) {
        System.out.println("dfs(" + w + ", " + z + ") 호출, count = " + count);
        if (w == b) {
            visited[b] = true;
            return;
        }

        if (!visited[w]) {
            visited[w] = true;
            System.out.println(w + "방문");
            for (int i = 0; i < kinship[w].size(); i++) {
                if (!visited[kinship[w].get(i)] && !visited[b]) {
                    count++;
                    dfs(kinship[w].get(i), z);
                    System.out.println("dfs(" + kinship[w].get(i) + ", " + z + ") 에서 반환");
                }
            }
        }
    }
}
