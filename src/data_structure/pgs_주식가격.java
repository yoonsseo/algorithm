package data_structure;

import java.util.Stack;

public class pgs_주식가격 {
    /*
    풀이를 참고하지 않았으면 생각하지 못했을 것 같다 ㅜ.ㅜ
     */

    class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < prices.length; i++) {
                while (!stack.empty() && prices[i] < prices[stack.peek()]) {
                    // 스택이 비어있지 않고 && 현재값보다 stack.peek()의 값이 더 크면
                    answer[stack.peek()] = i - stack.peek();
                    stack.pop();

                }
                stack.push(i);
            }

            while (!stack.empty()) {
                answer[stack.peek()] = prices.length - 1 - stack.peek();
                stack.pop();
            }

            return answer;
        }
    }
}
