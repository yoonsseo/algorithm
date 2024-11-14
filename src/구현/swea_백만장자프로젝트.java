package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class swea_백만장자프로젝트 {

    class Solution {

        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int T=Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= T; i++) {
                int N = Integer.parseInt(br.readLine());
                int[] price = new int[N];

                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    price[j] = Integer.parseInt(st.nextToken());
                }

                int max = 0;
                long sum = 0;
                for (int j = N - 1; 0 <= j; j--) {
                    if (max < price[j]) {
                        max = price[j];
                    } else {
                        sum += max - price[j];
                    }
                }

                sb.append("#").append(i).append(" ").append(sum).append("\n");
            }

            System.out.println(sb);
        }

    }
}
