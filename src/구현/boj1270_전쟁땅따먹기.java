package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1270_전쟁땅따먹기 {
    /*
     map에서 값만 정렬해도 최대값을 알 수 있으니까 상관없다고 생각했는데
     key 값이 필요하다
     */
    /*
     런타임 에러!
     입력받는 군사의 최댓값이 2^31이기 때문에 이는 int범위를 벗어나게 됩니다.(int범위 = 2^31 - 1)
     */

    static int n; // 땅의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken()); // 병사 수
            Map<Long, Integer> map = new HashMap<Long, Integer>(T);
            for (int j = 0; j < T; j++) {
                Long S = Long.parseLong(st.nextToken()); // 군대 번호
                if (map.get(S) != null) { // 해당 번호가 있으면
                    int v = map.get(S) + 1;
                    map.replace(S, v);
                } else { // 없으면 새로운 키
                    map.put(S, 1);
                }
            }

            /*
            List<Integer> valueList = new ArrayList<Integer>(map.values());
            valueList.stream().sorted().collect(Collectors.toList());
            double m = (double) T / valueList.get(0); // 과반수 확인 위한 변수
             */

            List<Map.Entry<Long, Integer>> entryList = new LinkedList<>(map.entrySet());
            entryList.sort((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey()));
            double m = (double) T / entryList.get(0).getValue(); // 과반수 확인 위한 변수
            if (m < 2) { // 과반수가 넘으면
                System.out.println(entryList.get(0).getKey());
            } else {
                System.out.println("SYJKGW");
            }
        }
    }
}
