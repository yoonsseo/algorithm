package data_structure;

import java.util.Scanner;
import java.util.Stack;

public class boj1874_스택수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        int value = 1;

        // 현재 수열값과 자연수의 비교
        // 자연수 <= 수열값 -> 자연수 스택에 push하기
        // 수열값 < 자연수 -> 스택에서 pop 하기
        for (int i = 0; i < n; i++) {
            if (value <= arr[i]) {
                while (value <= arr[i]) {
                    stack.push(value++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else { // arr[i] < value
                if (stack.peek() == arr[i]) {
                    stack.pop();
                    sb.append("-\n");
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println(sb.toString());
    }
}
