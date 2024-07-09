package data_structure;

import java.util.Stack;

public class pgs_짝지어제거하기 {
    // 짝을 지으라고 했을 때부터 stack 힌트를 눈치챘어야 했다

    class Solution {
        public int solution(String s) {
            int answer = 0;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                if (!stack.empty() && s.charAt(i) == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }

            if (stack.empty()) {
                answer = 1;
            }

            return answer;
        }
    }
}
