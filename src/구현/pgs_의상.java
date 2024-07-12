package 구현;

import java.util.Map;
import java.util.HashMap;

public class pgs_의상 {
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;

            Map<String, Integer> map = new HashMap<>(clothes.length);
            for (int i = 0; i < clothes.length; i++) {
                if (map.get(clothes[i][1]) != null) { // 이미 해당 키 값을 가지고 있으면
                    int v = map.get(clothes[i][1]) + 1;
                    map.replace(clothes[i][1], v);
                } else { // 새로운 키
                    map.put(clothes[i][1], 1);
                }
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                answer *= entry.getValue() + 1; // 착용하지 않는 가짓수 추가
            }

            return answer - 1; // 아무것도 착용하지 않은 경우 제외
        }
    }
}
