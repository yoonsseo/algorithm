package data_structure;

import java.util.Scanner;

public class boj1546_평균구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int score[] = new int[N];
        for (int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
        }

        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            sum += score[i];
            if (score[i] > max) {
                max = score[i];
            }
        }

        System.out.println((100.0 * sum / max) / N); // 실수형으로 변환
    }
}
