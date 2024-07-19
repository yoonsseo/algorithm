package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pgs_타겟넘버 {
    static int[] numbers;
    static int target;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        input = input.substring(1, input.length() - 1);
        String[] split = input.split(", ");
        numbers = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }

        target = Integer.parseInt(br.readLine());

        dfs(0, 0);

        System.out.println(count);
    }

    private static void dfs(int total, int idx) {
        if (idx == numbers.length) {
            if (total == target) {
                count++;
            }
            return;
        }

        if (idx < numbers.length) {
            dfs(Math.addExact(total, numbers[idx]), idx + 1);
            dfs(Math.subtractExact(total, numbers[idx]), idx + 1);
        }
    }
}
