package 문자열;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj1316_그룹단어체커 {
    // a는 아스키 코드로 97
    // 참고로 z는 122, A는 65, Z는 90

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int count = N;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            // 여기에서 초기화 해주어야!!
            boolean[] alphabet = new boolean[26];
            int prev = -1;
            int now;

            for (int j = 0; j < input.length(); j++) {
                now = (int) input.charAt(j) - 97;

                if (prev != now) { // 앞 문자와 다른 문자
                    if (!alphabet[now]) { // 새로운 문자
                        alphabet[now] = true;
                    } else { // 앞 문자와 다른 문자인데 새로운 문자가 아님
                        count--;
                        break;
                    }
                }
                // 앞 문자와 같은 문자라면 연속

                prev = now;
            }
        }
        System.out.println(count);
    }
}
