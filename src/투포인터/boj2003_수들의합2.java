package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2003_수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = 1;
        int sum = 0;
        int count = 0;
        while (start <= N) {
            if (sum == M) {
                count++;
                sum -= A[start];
                start++;
            } else if (M < sum || N < end) {
                sum -= A[start];
                start++;
            } else { // sum < M
                sum += A[end];
                end++;
            }
        }

        System.out.println(count);
    }
}
