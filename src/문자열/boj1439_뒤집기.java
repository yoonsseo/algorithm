package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1439_뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");
        int[] A = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            A[i] = Integer.parseInt(split[i]);
        }

        int zero = 0; // 0의 묶음
        int one = 0; // 1의 묶음
        if (A[0] == 0) {
            zero++;
        } else {
            one++;
        }

        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] != A[i]) { // 다른 경우
                if (A[i] == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
        }

        System.out.println(Math.min(zero, one));
    }
}
