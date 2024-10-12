package 구현;

import java.util.*;

public class pgs_롤케이크자르기 {

    class Solution {
        public int solution(int[] topping) {
            int answer = 0;

            Map<Integer, Integer> b1 = new HashMap<>();
            Map<Integer, Integer> b2 = new HashMap<>();

            for (int i = 0; i < topping.length; i++) {
                b1.put(topping[i], b1.getOrDefault(topping[i], 0) + 1);
            }

            for (int i = 0; i < topping.length - 1; i++) {
                b2.put(topping[i], b2.getOrDefault(topping[i], 0) + 1);

                if (b1.get(topping[i]) == 1) {
                    b1.remove(topping[i]);
                } else {
                    b1.replace(topping[i], b1.get(topping[i]) - 1);
                }

                if (b1.size() == b2.size()) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
