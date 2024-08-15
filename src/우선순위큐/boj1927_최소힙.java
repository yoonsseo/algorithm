package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 연산 수

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        // 자연수이면 값 추가, 0이면 최소값 출력
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pQueue.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(pQueue.poll());
                }
                sb.append("\n");
            } else {
                pQueue.offer(x);
            }
        }

        System.out.println(sb);
    }
}
