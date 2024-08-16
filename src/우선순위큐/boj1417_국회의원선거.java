package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Collections;

public class boj1417_국회의원선거 {
    /*
    우선순위 큐로 풀기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        int count = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            pQueue.offer(Integer.parseInt(br.readLine()));
        }

        int need = 0;
        while (!pQueue.isEmpty() && count <= pQueue.peek()) {
            pQueue.offer(pQueue.poll() - 1);
            count++;
            need++;
        }

        System.out.println(need);
    }
}
