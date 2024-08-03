package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9324_진짜메시지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int[] alphabet;

        for (int i = 0; i < N; i++) {
            String msg = br.readLine();
            alphabet = new int[26];
            boolean flag = true;
            for (int j = 0; j < msg.length(); j++) {
                alphabet[msg.charAt(j) - 65]++;

                if (alphabet[msg.charAt(j) - 65] == 3) {
                    if (j != msg.length() - 1 && msg.charAt(j + 1) == msg.charAt(j)) {
                        j++;
                        alphabet[msg.charAt(j) - 65] = 0;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                sb.append("OK\n");
            }
            else {
                sb.append("FAKE\n");
            }
        }

        System.out.println(sb);
    }
}
