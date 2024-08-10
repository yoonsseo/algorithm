package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj5555_반지 {
    /*
    이어져있는 문자열을 어떻게 처리해야하나 고민했는데 그냥 문자열을 두 배해서 찾으면 된다!!
     */

    static String input; // 찾고자 하는 문자열
    static int N; // 반지 개수
    static int count = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String ring = br.readLine();
            ring += ring;
            if (ring.contains(input)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
