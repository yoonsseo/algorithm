package data_structure;

import java.util.Stack;

public class pgs_택배상자 {
    class Solution {
        public int solution(int[] order) {
            int answer = 0;
            int N = order.length;
            Stack<Integer> stack = new Stack<>();

            int idx = 0; // 현재 트럭에 실어야 하는 택배 번호
            for (int i = 0; i < N; i++) {
                if (order[idx] - 1 != i) { // 현재 전달되는 택배 순서가 아니면
                    stack.push(i); // 보조 컨베이너 벨트로
                } else { // 트럭에 실을 올바른 순서이면
                    stack.push(i);
                    while (!stack.empty() && stack.peek() == order[idx] - 1) {
                        stack.pop();
                        answer++; // 트럭에 넣기
                        idx++;
                    }
                }
            }

            return answer;
        }
    }
}
