package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj18352_특정거리의도시찾기 {
    /*
     오름차순으로 출력!
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시 개수
        int M = Integer.parseInt(st.nextToken()); // 도로 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시 번호

        ArrayList<Integer>[] map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[N + 1]; // X로부터 거리
        Arrays.fill(distance, 300003); // 도시의 최대 개수 300000
        List<Integer> answer = new ArrayList<>(); // X와 거리가 K인 도시 번호

        queue.offer(X);
        distance[X] = 0;

        while (!queue.isEmpty()) {
            int city = queue.poll();

            for (int next : map[city]) { // city와 이어져 있는 도시 번호
                if (distance[next] == 300003) { // 방문한 적 없으면
                    queue.offer(next);
                    distance[next] = distance[city] + 1;
                    if (distance[next] == K) {
                        answer.add(next);
                    }
                }
            }
        }

        if (answer.size() == 0) {
            System.out.println(-1);
        } else {
            answer.sort(Comparator.naturalOrder());
            for (int i = 0; i < answer.size(); i++) {
                System.out.println(answer.get(i));
            }
        }

    }
}
