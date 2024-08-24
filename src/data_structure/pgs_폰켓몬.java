package data_structure;

import java.util.Map;
import java.util.HashMap;

public class pgs_폰켓몬 {
    /*
    set으로 풀면 조금 더 간단해질 듯
     */

    class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            Map<Integer, Integer> map = new HashMap<>();

            int kind = 0;
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (map.get(nums[i]) == null) {
                    map.put(nums[i], 1);
                    kind++;
                } else {
                    int v = map.get(nums[i]);
                    map.replace(nums[i], v + 1);
                }
                //map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            if (kind <= nums.length / 2) {
                answer = kind;
            } else {  // nums.length / 2 <= kind
                answer = nums.length / 2;
            }

            return answer;
        }
    }
}
