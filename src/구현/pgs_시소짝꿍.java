package 구현;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class pgs_시소짝꿍 {
    class Solution {
        static Map<Double, Integer> map = new HashMap<>();
        static double[] distance = {1.0, 2.0 / 3, 2.0 / 4, 3.0 / 4};

        public long solution(int[] weights) {
            long answer = 0;

            Arrays.sort(weights);

            for (int i = 0; i < weights.length; i++) {
                for (int j = 0; j < distance.length; j++) {
                    if (map.containsKey(weights[i] * distance[j])) {
                        answer += map.get(weights[i] * distance[j]);
                    }
                }
                map.put((double) weights[i], map.getOrDefault((double) weights[i], 0) + 1);
            }

            return answer;
        }
    }
}
