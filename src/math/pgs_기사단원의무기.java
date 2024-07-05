package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pgs_기사단원의무기 {
    static int N; // 기사단원 수
    static int L; // 공격력 제한수치
    static int P; // 제한수치 초과 시 공격력

    static int[] D; // 1~N 별로 약수의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        D = new int[N + 1];

        System.out.println(solution(N, L, P));
    }

    static int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            D[i] = calcD(i);
            if (limit < D[i]) {
                D[i] = power;
            }
            answer += D[i];
        }

        return answer;
    }

    static int calcD(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) {
                count++;
            } else if (n % i == 0) {
                count += 2;
            }
        }
        return count;
    }
}
