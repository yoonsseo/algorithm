package 구현;

import java.util.Queue;
import java.util.LinkedList;

public class pgs_기능개발 {

    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer;

            // 각 작업마다 배포까지 걸리는 기간
            int[] period = new int[progresses.length];
            for (int i = 0; i < progresses.length; i++) {
                // int leftProgresses = 100 - progresses[i];
                // double Q = (double) (100 - progresses[i]) / speeds[i];
                // int leftDays = Math.ceil((double) (100 - progresses[i]) / speeds[i]);
                period[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
                System.out.print(period[i] + " ");
            }
            System.out.println();

            Queue<Integer> queue = new LinkedList<>();
            int prevDeploy = period[0];
            int count = 1;
            for (int i = 1; i < period.length; i++) {
                if (period[i] <= prevDeploy) {
                    count++;
                } else {
                    queue.offer(count);
                    prevDeploy = period[i];
                    count = 1;
                }
            }
            queue.offer(count);

            answer = new int[queue.size()];
            for (int i = 0; i <= queue.size(); i++) {
                System.out.println(queue.peek());
                answer[i] = queue.poll();
            }
            // answer[queue.size()] = count;

            return answer;
        }
    }}
