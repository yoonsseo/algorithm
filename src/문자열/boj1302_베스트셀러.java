package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1302_베스트셀러 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map =new HashMap<>();
        for (int i = 0; i < N; i++) {
            String title = br.readLine();
            map.put(title, map.getOrDefault(title, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + "  = " + entry.getValue());
        }

        int max = entryList.get(0).getValue();
        if (entryList.size() > 1 && entryList.get(1).getValue() == max) { // 베스트 셀러가 여러 권
            List<String> list = new ArrayList<>();
            for (int i = 0; i < entryList.size(); i++) {
                if (entryList.get(i).getValue() == max) {
                    list.add(entryList.get(i).getKey());
                } else {
                    break;
                }
            }
            Collections.sort(list);
            System.out.println(list.get(0));
        } else {
            System.out.println(entryList.get(0).getKey());
        }
    }
}
