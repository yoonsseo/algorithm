package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class boj31416_가상검증기술 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (0 < T) {
            st = new StringTokenizer(br.readLine());
            int Ta = Integer.parseInt(st.nextToken());
            int Tb = Integer.parseInt(st.nextToken());
            int Va = Integer.parseInt(st.nextToken());
            int Vb = Integer.parseInt(st.nextToken());

            int A = Ta * Va;
            int B = Tb * Vb;
            int R = (A - B) / Ta;
            int C = (int) Math.ceil(R / 2.0);
            int F = (int) Math.floor(R / 2.0);

            if (A <= B) {
                System.out.println(B);
            } else { // Tb * Vb < Ta * Va
                int min;

                if (R % 2 == 0) {
                    R /= 2;
                    A -= Ta * R;
                    B += Ta * R;
                    min = Math.max(A, B);
                } else {
                    // ceil
                    A -= Ta * C;
                    B += Ta * C;
                    int temp1 = Math.max(A, B);

                    // floor
                    A -= Ta * F;
                    B += Ta * F;
                    int temp2 = Math.max(A, B);

                    min = Math.min(temp1, temp2);
                }

                System.out.println(min);
            }

            T--;
        }
    }
}
