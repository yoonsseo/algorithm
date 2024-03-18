package data_structure;

import java.util.Scanner;

public class boj11659_구간합구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
//        int[] A = new int[N + 1]; // 입력 배열을 저장할 필요가 없음
        int[] S = new int[N + 2];
        S[0] = 0;
        for (int i = 1; i < N + 1; i++) {
            S[i] = S[i - 1] + sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(S[end] - S[start-1]);
        }
    }
}
