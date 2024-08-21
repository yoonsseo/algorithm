package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj12847_꿀아르바이트 {
    /*
    int -> long,,,
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] wage = new int[N];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            wage[i] = Integer.parseInt(st.nextToken());
            if (i < M) {
                sum += wage[i];
            }
        }

        long max = sum;
        int start = 0;
        int end = M - 1;
        while (end <= N - 2) {
            sum -= wage[start];
            start++;
            end++;
            sum += wage[end];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
