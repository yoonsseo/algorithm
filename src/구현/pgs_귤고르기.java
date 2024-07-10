package 구현;

import java.util.*;

public class pgs_귤고르기 {
    // HashMap 전체를 정렬했는데 value만 정렬해도 되겠다
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int count = 0;

        Map<Integer, Integer> hm = new HashMap<Integer, Integer>(tangerine.length + 1);
        for (int i = 0; i < tangerine.length; i++) {
            if (hm.get(tangerine[i]) != null) {
                int v = hm.get(tangerine[i]) + 1;
                hm.replace(tangerine[i], v);
            } else {
                hm.put(tangerine[i], 1);
            }
        }

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(hm.entrySet());
        entryList.sort((o1, o2) -> hm.get(o2.getKey()) - hm.get(o1.getKey()));
        for (Map.Entry<Integer, Integer> entry : entryList) {
            count += entry.getValue();
            if (k <= count) {
                answer++;
                break;
            }
            answer++;
        }

        return answer;
    }
}
