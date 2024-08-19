package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2018_수들의합5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int start = 1;
        int end = 1;
        int sum = 1;

        while (start <= N) {
            if (sum < N) {
                end++;
                sum += end;
            } else if (sum == N) {
                count++;
                sum -= start;
                start++;
            } else { // N < sum
                sum -= start;
                start++;
            }
        }

        System.out.println(count);
    }
}
