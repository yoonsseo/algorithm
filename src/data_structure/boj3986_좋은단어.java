package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj3986_좋은단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < input.length(); j++) {
                if (!stack.empty() && stack.peek() == input.charAt(j)) {
                    stack.pop();
                } else {
                    stack.push(input.charAt(j));
                }
            }
            if (stack.empty()) {
                count++;
            }
        }

        System.out.println(count);
    }
}
