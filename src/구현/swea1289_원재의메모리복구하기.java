package 구현;

import java.io.*;

public class swea1289_원재의메모리복구하기 {

    static class Solution {

        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            for (int tc = 1; tc <= T; tc++) {
                String s = br.readLine();
                char prev = s.charAt(0);
                int count = prev == '1' ? 1 : 0;

                for (int i = 1; i < s.length(); i++) {
                    char now = s.charAt(i);
                    if (now != prev) {
                        count++;
                    }
                    prev = now;
                }

                sb.append("#").append(tc).append(" ").append(count).append("\n");
            }

            System.out.println(sb);
        }

    }
}
