package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj23757_아이들과선물상자 {
    /*
    처음에 아이들이 원하는 선물의 개수를 정렬시켰는데 아이들은 순서대로 선물을 받는다
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 선물 상자 수
        int M = Integer.parseInt(st.nextToken()); // 아이들 수

        int[] want = new int[M];
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pQueue.offer(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            want[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = true;
        for (int i = 0; i < M; i++) {
            if (!pQueue.isEmpty() && want[i] <= pQueue.peek()) {
                pQueue.offer(pQueue.poll() - want[i]);
            } else {
                flag = false;
            }
        }

        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
