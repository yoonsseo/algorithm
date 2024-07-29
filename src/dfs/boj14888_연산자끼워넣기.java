package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14888_연산자끼워넣기 {
    static int N;
    static int[] num;

    // 0  1  2  3
    // +, -, ×, ÷
    static int[] op = new int[4];

    static int max = -1000000000;
    static int min = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[0], 1);

        System.out.println(max + "\n" + min);
    }

    static void dfs(int calc, int idx) {
        if (idx == N) {
            max = Math.max(max, calc);
            min = Math.min(min, calc);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (0 < op[i]) {
                op[i]--;
                switch (i) {
                    case 0:
                        dfs(calc + num[idx], idx + 1);
                        break;
                    case 1:
                        dfs(calc - num[idx], idx + 1);
                        break;
                    case 2:
                        dfs(calc * num[idx], idx + 1);
                        break;
                    case 3:
                        dfs(div(calc, num[idx]), idx + 1);
                        break;
                }
                op[i]++;
            }
        }

    }

    static int div(int a, int b) {
        if (0 <= a) {
            return a / b;
        } else { // 음수의 나눗셈
            // 나눗셈은 정수 나눗셈으로 몫만 취한다.
            // 음수를 양수로 나눌 때는 C++14의 기준을 따른다.
            // 즉, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다
            return -(Math.abs(a) / b);
        }
    }
}
