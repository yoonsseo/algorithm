package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class pgs_할인행사 {
    /*
    문제를 읽어보면 10일동안 할인 적용 시 원하는 물품을 구입할 수 있는 날의 개수 구하기
    최소 일자가 아니라, 가능한 날의 개수!
     */
    static Map<String, Integer> map = new HashMap<>();
    static Map<String, Integer> countMap = new HashMap<>();
    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String w = br.readLine();
        String wa = w.substring(2, w.length() - 2);
        String[] want = wa.split("\", \"");

        String n = br.readLine();
        String nu = n.substring(1, n.length() - 1);
        String[] num = nu.split(", ");
        int[] number = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            number[i] = Integer.parseInt(num[i]);
        }

        String d = br.readLine();
        String dis = d.substring(2, d.length() - 2);
        String[] discount = dis.split("\", \"");

        System.out.println(solution(want, number, discount));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        countMap = (Map<String, Integer>) ((HashMap<String, Integer>) map).clone();

        int start = 0;
        int end = 0;
        while (start <= discount.length - 10) {
            int d = start + 1;
            System.out.println("\n\n[" + d + "일차]");
            if (total < 10)
                for (int j = end; j < start + 10; j++) {
                    System.out.print("j = " + j);
                    if (countMap.containsKey(discount[j]) && 0 < countMap.get(discount[j])) {
                        // 할인하는 물건이 원하는 물건이고 && 아직 사야 한다
                        countMap.replace(discount[j], countMap.get(discount[j]) - 1);
                        total++;
                        System.out.println(" 물건: " + discount[j] + ", 총량: " + total);
                    } else { // 원상복구
                        if (countMap.containsKey(discount[start])) {
                            System.out.println("\n원하는 물건이지만 이미 모두 구매하여 원상복구 ");
                            // 인덱스 변경으로 맨 처음에 count한 물건 원상복구
                            countMap.replace(discount[start], countMap.get(discount[start]) + 1);
                            total--;
                            end = j; // 해당 인덱스 이어서 진행
                            start++; // 두 번째 인덱스부터 이어서 진행
                        } else {
                            System.out.println("\n원하는 물건이 아니라 원상복구 ");
                            // 다음 인덱스부터 처음부터 count 진행해야 한다
                            countMap = (Map<String, Integer>) ((HashMap<String, Integer>) map).clone();
                            total = 0;
                            end = j + 1;
                            start = end;
                        }
                        break;
                    }
                }

            if (total == 10) {
                answer++;
                System.out.print("\n" + start + "번째 날 가능");
                countMap.replace(discount[start], countMap.get(discount[start]) + 1);
                total--;
                end = start + 10;
                start++;
            }
        }


        return answer;
    }
}

