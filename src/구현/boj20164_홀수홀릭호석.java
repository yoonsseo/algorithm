package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj20164_홀수홀릭호석 {
    /*
    자리수가 높지 않아서 완전 탐색으로 풀 수 있었다
     */

    static int min = 999999999;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());

        partition(inputNum, 0);

        System.out.println(min + " " + max);
    }

    private static void partition(int num, int count) {
        count += countOdd(num);

        if ((num / 10) == 0) { // 한 자리 수
            min = Math.min(min, count);
            max = Math.max(max, count);
        } else if (num / 100 == 0) { // 두 자리 수
            int sum = num / 10;
            sum += num % 10;
            partition(sum, count);
        } else { // 세 자리 수 이상
            String numString = String.valueOf(num);
            int len = numString.length(); // 마지막 idx는 len - 1;
            for (int i = 1; i <= len - 2; i++) {
                for (int j = i + 1; j <= len - 1; j++) {
                    int first = Integer.parseInt(numString.substring(0, i));
                    int second = Integer.parseInt(numString.substring(i, j));
                    int third = Integer.parseInt(numString.substring(j));
                    int sum = first + second + third;
                    partition(sum, count);
                }
            }
        }

    }

    private static int countOdd(int num) {
        int count = 0;

        while (0 < num) {
            if ((num % 10) % 2 == 1) {
                count++;
            }

            num /= 10;
        }

        return count;
    }
}
