package 구현;

import java.io.*;

public class swea2805_농작물수확하기 {

    class Solution {

        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            for (int t = 1; t <= T; t++) {
                int N = Integer.parseInt(br.readLine());
                int M = N / 2;
                int sum = 0;

                for (int i = 0; i < N; i++) {
                    String s = br.readLine();
                    int d = Math.abs(M - i);
                    for (int j = d; j < N - d; j++) {
                        sum += Integer.parseInt(String.valueOf(s.charAt(j)));
                    }
                }

                sb.append("#").append(t).append(" ").append(sum).append("\n");
            }

            System.out.println(sb);
        }

    }
}
