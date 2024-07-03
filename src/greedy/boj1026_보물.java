package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj1026_보물 {

    static int N;
    static Integer[] A;
    static Integer[] B;
    static Integer S = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new Integer[N];
        B = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            A[i] = a;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int b = Integer.parseInt(st.nextToken());
            B[i] = b;
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            S += A[i] * B[i];
        }

        System.out.println(S);
    }
}
