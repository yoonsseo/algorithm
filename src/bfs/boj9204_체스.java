package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj9204_체스 {
    static boolean[][] visited;
    static Point start;
    static Point end;

    // nw ne se sw
    static int[][] d = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < T; i++) {
            visited = new boolean[8][8];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int y1 = (char) st.nextToken().charAt(0) - 65;
            int x1 = 8 - Integer.parseInt(st.nextToken());
            List<Point> list1 = new ArrayList<>();
            list1.add(new Point(x1, y1));
            start = new Point(x1, y1, 0, list1);

            int y2 = (char) st.nextToken().charAt(0) - 65;
            int x2 = 8 - Integer.parseInt(st.nextToken());
            List<Point> list2 = new ArrayList<>();
            list2.add(new Point(x2, y2));
            end = new Point(x2, y2, 0, list2);

//            System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);

            if (x1 == x2 && y1 == y2) {
                sb.append("0 ").append((char) (y1 + 65)).append(" ").append((8 - x1));
                sb.append("\n");
                continue;
            }

            if (Math.abs(x1 - x2) % 2 != Math.abs(y1 - y2) % 2) {
                sb.append("Impossible");
                sb.append("\n");
                continue;
            }

            List<Point> list = bfs();
            if (list == null) {
                sb.append("Impossible");
                sb.append("\n");
                continue;
            }
            sb.append(list.size() - 1);
            for (Point p : list) {
                sb.append(" ").append((char) (p.y + 65)).append(" ").append(8 - p.x);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static List<Point> bfs() {
        Queue<Point> queue = new LinkedList<>();
        int count = 0; // 최대 4번까지 움직일 수 있다

        queue.offer(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x;
                int ny = now.y;
                while (rangeCheck(nx, ny)) {
                    nx += d[i][0];
                    ny += d[i][1];
                    if (rangeCheck(nx, ny) && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        List<Point> list = new ArrayList<>(now.list);
                        list.add(new Point(nx, ny));

                        if (nx == end.x && ny == end.y) {
                            return list;
                        }

                        if (now.count == 4) {
                            return null;
                        }

                        queue.offer(new Point(nx, ny, now.count + 1, list));
                    }
                }
            }
        }

        return null;
    }

    private static boolean rangeCheck(int x, int y) {
        return (0 <= x && x < 8 && 0 <= y && y < 8);
    }

    private static class Point {
        int x;
        int y;
        int count;
        List<Point> list;

        public Point(int x, int y, int count, List<Point> list) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.list = list;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
