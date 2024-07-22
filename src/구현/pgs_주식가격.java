package 구현;

import java.util.Arrays;

public class pgs_주식가격 {
    /*
    10만번 반복 시간 초과
     */
    class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            boolean[] uptrend = new boolean[prices.length];
            Arrays.fill(uptrend, true);

            for (int i = 1; i < prices.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (uptrend[j]) {
                        if (prices[j] <= prices[i]) {
                            answer[j]++;
                        } else {
                            answer[j]++;
                            uptrend[j] = false;
                        }
                    }
                }
            }

            return answer;
        }
    }
}
