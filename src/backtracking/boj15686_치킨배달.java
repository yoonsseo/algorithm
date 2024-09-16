package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj15686_치킨배달 {
    /*
    최대 M개이면 더 적을 수도 있는 거 아닌가? 이 표현 때문에 엄청 헷갈렸다
    하지만 count <= M 으로 조건을 수정하면 틀린다
    왜 그냥 M개가 아니라 최대 M개라는 표현을 썼을까,,
     */

    static int N;
    static int M;
    static int[][] city;

    static List<Point> house = new ArrayList<>();
    static List<Point> chicken = new ArrayList<>();
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) {
                    house.add(new Point(i, j));
                } else if (city[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        visited = new boolean[chicken.size()];

        dfs(0, 0);

        System.out.println(min);
    }

    private static void dfs(int count, int idx) {

        if (count == M) {
            int total = 0; // 치킨 거리 합
            for (int i = 0; i < house.size(); i++) { // 집집마다 최소 치킨 거리 구하기
                Point H = house.get(i);
                int dis = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {
                        Point C = chicken.get(j);
                        int d = Math.abs(C.x - H.x) + Math.abs(C.y - H.y);
                        dis = Math.min(dis, d);
                    }
                }
                total += dis;
            }

            min = Math.min(min, total);
        }

        for (int i = idx; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(count + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
