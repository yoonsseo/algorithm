package data_structure;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class pgs_올바른괄호 {

    static class Solution {
        boolean solution(String s) {
            boolean answer = false;
            Stack<String> stack = new Stack<>();
            Queue<String> queue = new LinkedList<>();

            for (int i = 0; i < s.length(); i++) {
                if (String.valueOf(s.charAt(i)).equals("(")) {
                    stack.push("(");
                } else { // .equals(")")
                    if (!stack.empty() && stack.peek().equals("(")) {
                        stack.pop();
                    } else { // 스택이 비었거나 peek가 "("이 아닌 경우
                        queue.offer(String.valueOf(s.charAt(i)));
                    }
                }
            }

            if (stack.empty() && queue.isEmpty()) {
                answer = true;
            }

            return answer;
        }
    }
}

