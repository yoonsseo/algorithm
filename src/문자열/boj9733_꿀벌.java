package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj9733_꿀벌 {
    /* 출력은 {Re,Pt,Cc,Ea,Tb,Cm,Ex} 순서대로 하며,
    비율은 소수점 둘째 자리까지 출력한다.
    주어진 목록에 없는 일은 출력하지 않는다.
     */
    static Map<String, Integer> chore = new HashMap<>();
    static int total = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while ((s = br.readLine()) != null) {
            String[] split = s.split(" ");
            for (int i = 0; i < split.length; i++) {
                chore.put(split[i], chore.getOrDefault(split[i], 0) + 1);
            }
            total += split.length;
        }

        // 정렬할 키의 순서 정의
        List<String> order = Arrays.asList("Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex");

        // 정렬된 결과를 저장할 리스트 생성
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>();

        // 맵의 각 항목을 리스트에 추가
        for (String key : order) {
            if (chore.containsKey(key)) {
                sortedList.add(new AbstractMap.SimpleEntry<>(key, chore.get(key)));
            }
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : sortedList) {
            String format = String.format("%.2f", stringIntegerEntry.getValue() / (double) total);
            System.out.println(stringIntegerEntry.getKey() + " " + stringIntegerEntry.getValue() + " " + format);
        }

        System.out.println("Total " + total + " 1.00");
    }
}
