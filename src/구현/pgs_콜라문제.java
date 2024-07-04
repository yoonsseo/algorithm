package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pgs_콜라문제 {
    static int A; // 마트에 주어야 하는 콜라병 수
    static int B; // 마트가 주는 콜라병 수
    static int N; // 가지고 있는 콜라병 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        System.out.println(solution(A, B, N));

    }

    static int solution(int a, int b, int n) {
        int answer = 0;

        int Q;
        int R;
        while (a <= n) {
            Q = n/a;
            R = n%a;
            answer += Q * b;
            n = R + Q * b;
        }

        return answer;
    }
}
