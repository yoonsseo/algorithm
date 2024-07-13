package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9655_돌게임 {
    /*
    N == 1 : 상근1
    N == 2 : 상근1 창영1
    N == 3 : 상근3
             상근1 창영1 상근1
    N == 4 : 상근3 창영1
             상근1 창영3
             상근1 창영1 상근1 창영1
    N == 5 : 상근3 창영1 상근1
             상근1 창영3 상근1
             상근1 창영1 상근1 창영1 상근1
    N == 6 : 상근3 창영3
             상근3 창영1 상근1 창영1
             상근1 창영3 상근1 창영1
             상근1 창영1 상근1 창영1 상근1 창영1
    N == 7 : 상근3 창영3 상근1
             상근3 창영1 상근3
             ...
     */
    static int N; // 돌 개수
//    static int[]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }

    }
}
