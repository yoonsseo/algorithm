package 구현;

import java.util.Arrays;

public class pgs_영어끝말잇기 {

    class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = {0, 0};
            boolean flag = true;
            int turn = 2; // 어떤 사람
            int time = 1; // 차례
            String prev = words[0];
            String now;
            String[] said = new String[words.length];
            said[0] = words[0];
            // 배열을 미리 초기화 해주지 않으면 findRepeat에서 NullPointerException 발생
            for (int i = 1; i < said.length; i++) {
                said[i] = "@";
            }

            for (int i = 1; i < words.length; i++) {
                System.out.println("i = " + i);
                now = words[i];
                if (checkChain(prev, now) && findRepeat(said, now) < 0) {
                    // 단어가 이어지고, 말한 적 없는 단어이면
                    said[i] = words[i];
                    prev = now;
                    turn++;
                    if (turn > n) {
                        turn = 1;
                        time++;
                    }
                    System.out.println("prev = " + prev + " turn = " + turn + " time = " + time);
                } else {
                    flag = false;
                    break;
                }

            }

            if (!flag) {
                System.out.println("flag = " + flag + " answer = " + Arrays.toString(answer));
                answer[0] = turn;
                answer[1] = time;
            }

            return answer;
        }

        private boolean checkChain(String prev, String now) {
            if (prev.charAt(prev.length() - 1) == now.charAt(0)) {
                return true;
            }

            return false;
        }

        // 정렬된 배열을 binarySearch로 확인해 해당 단어가 배열에 있는지 확인
        // 있으면 해당 인덱스를, 없으면 음수 반환
        private int findRepeat(String[] said, String now) {
            String[] copiedArr = Arrays.copyOf(said, said.length);
            // 원본이 정렬되기 때문에 인덱스가 달라질 수 있다
            Arrays.sort(copiedArr);
            System.out.println(Arrays.toString(copiedArr));
            System.out.println(Arrays.binarySearch(copiedArr, now));
            return Arrays.binarySearch(copiedArr, now);
        }
    }
}
