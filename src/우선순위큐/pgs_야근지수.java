package 우선순위큐;

import java.util.*;

public class pgs_야근지수 {

    class Solution {
        public long solution(int n, int[] works) {
            long answer = 0;

            PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < works.length; i++) {
                pQueue.offer(works[i]);
            }

            for (int i = 0; i < n; i++) {
                if (!pQueue.isEmpty()) {
                    int R = pQueue.poll() - 1;
                    if (0 < R) {
                        pQueue.offer(R);
                    }
                }
            }

            while (!pQueue.isEmpty()) {
                answer += Math.pow(pQueue.poll(), 2);
            }

            return answer;
        }
    }
}
