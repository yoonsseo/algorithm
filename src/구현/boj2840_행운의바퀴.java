package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2840_행운의바퀴 {
    static int N; // 바퀴 칸 수
    static int K; // 회전 수
    static boolean[] alphabet = new boolean[26];
    static String[] letter; // 바퀴에 있는 글자
    static int now = 0; // 룰렛 현재 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        letter = new String[N];
        Arrays.fill(letter, "?");

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 회전 시 바퀴 칸의 이동 수
            String c = st.nextToken(); // 회전이 멈추었을 때 가리키는 문자

            now = (now + s) % N;

            if (letter[now].equals("?") && !alphabet[(int) c.charAt(0) - 65]) {
                alphabet[(int) c.charAt(0) - 65] = true;
                letter[now] = c;
            } else if (letter[now].equals(c)) {
                continue;
            } else {
                System.out.println("!");
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            int idx = now - i;
            if (idx < 0) {
                idx += N;
            }
            System.out.print(letter[idx]);
        }
    }
}
