package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj21921_블로그 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 블로그 시작 일 수
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] visit = new int[N];
        for (int i = 0; i < N; i++) {
            visit[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < X; i++) {
            sum += visit[i];
        }

        int start = 0;
        int end = X - 1;
        long max = sum;
        int count = 1;

        while (end <= N - 2) {
            sum -= visit[start];
            start++;
            end++;
            sum += visit[end];
            if (max < sum) {
                max = sum;
                count = 1;
            } else if (max == sum) {
                count++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max + "\n" + count);
        }
    }
}
