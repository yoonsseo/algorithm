package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj14235_크리스마스선물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                if (pQueue.isEmpty()) {
                    System.out.println(-1);
                    sb.append(-1);
                } else {
                    System.out.println(pQueue.poll());
                }
            } else {
                for (int j = 0; j < a; j++) {
                    pQueue.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }
    }
}
