package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class pgs_기능개발 {
    /*
    queue의 size()는 계속 변하는데
    for문을 돌 때 제한 범위를 queue.size()로 설정해 오래 해맸음 ㅜ.ㅜ
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputString = br.readLine();
        inputString = inputString.substring(1, inputString.length() - 1);
        String[] input = inputString.split(", ");
        int[] progresses = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            progresses[i] = Integer.parseInt(input[i]);
        }

        inputString = br.readLine();
        inputString = inputString.substring(1, inputString.length() - 1);
        input = inputString.split(", ");
        int[] speeds = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            speeds[i] = Integer.parseInt(input[i]);
        }

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }


    private static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;

        // 각 작업마다 배포까지 걸리는 기간
        int[] period = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            period[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
        }

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
        for (int i = 0; i < answer.length; i++) { // 여기에서 queue.size()로 설정하면 queue의 size()는 계속 변하기 때문에 안 됨!
            answer[i] = queue.poll();
        }

        return answer;

    }
}
