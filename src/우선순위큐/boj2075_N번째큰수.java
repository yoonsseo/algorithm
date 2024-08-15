package 우선순위큐;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj2075_N번째큰수 {
    /*
    메모리 제한이 굉장히 작아서 모든 자료를 저장하면 안 된다
    근데 자바 11로는 풀리는데 자바 15로는 메모리 초과..! 뭐지뭐지ㅠ
    -> 모든 자료를 저장해도 N개만 저장해도
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

        int min = -1000000000;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int q = Integer.parseInt(st.nextToken());
                pQueue.offer(q);
                if (pQueue.size() == N) {
                    if (q < min) {
                        pQueue.remove(q);
                        min = q;
                    }
                }
            }
        }

        for (int i = 0; i <= N - 2; i++) {
            pQueue.poll();
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(pQueue.poll());
        bw.flush();
        bw.close();
    }
}
