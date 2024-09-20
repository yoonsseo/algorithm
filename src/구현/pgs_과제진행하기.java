package 구현;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class pgs_과제진행하기 {
    /*
    다음 과제 시작까지 여유가 있으면 하다 만 과제 남은 시간 갱신해야함
     */

    class Solution {
        public List<String> solution(String[][] plans) {
            List<String> answer = new ArrayList<>();
            // System.out.println(plans[0][0]); // korean
            // System.out.println(plans[0][1]); // 11:40
            // System.out.println(plans[1][0]); // english

            Map<Integer, Integer> start = new HashMap<>();

            for (int i = 0 ; i < plans.length; i++) {
                String[] time = plans[i][1].split(":");
                plans[i][1] = String.valueOf(
                        Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
                start.put(i, Integer.parseInt(plans[i][1]));
            }

            List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(start.entrySet());
            entryList.sort((o1, o2) -> o1.getValue() - o2.getValue());

            int prev, prevRemainTime;
            int now, nowStartTime;
            int next, nextStartTime;
            int spareTime;
            int currentTime = 0;

            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < entryList.size() - 1; i++) {
                now = entryList.get(i).getKey();
                nowStartTime = Integer.parseInt(plans[now][1]);

                next = entryList.get(i + 1).getKey();
                nextStartTime = Integer.parseInt(plans[next][1]);

                spareTime = nextStartTime - nowStartTime;
                if (spareTime < Integer.parseInt(plans[now][2])) { // 시간 부족
                    stack.push(now);
                    plans[now][2] = String.valueOf(
                            Integer.parseInt(plans[now][2]) - spareTime);
                } else { // 시간 충분
                    answer.add(plans[now][0]);

                    currentTime = nowStartTime + Integer.parseInt(plans[now][2]);
                    while (!stack.isEmpty()) {
                        prev = stack.peek();
                        prevRemainTime = Integer.parseInt(plans[prev][2]);
                        spareTime = nextStartTime - currentTime;

                        if (prevRemainTime <= spareTime) { // 시간 충분
                            answer.add(plans[prev][0]);
                            stack.pop();
                            currentTime += prevRemainTime;
                        } else {
                            plans[prev][2] = String.valueOf(
                                    Integer.parseInt(plans[prev][2]) - spareTime);
                            break;
                        }
                    }

                } // else
            }

            now = entryList.get(entryList.size() - 1).getKey();
            answer.add(plans[now][0]);

            while (!stack.isEmpty()) {
                int idx = stack.pop();
                answer.add(plans[idx][0]);
            }

            return answer;
        }
    }
}
