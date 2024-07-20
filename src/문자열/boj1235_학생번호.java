package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class boj1235_학생번호 {
    static int N; // 학생 수
    static String[] num;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new String[N];

        for (int i = 0; i < N; i++) {
            num[i] = br.readLine();
        }

        for (int i = 1; i <= num[0].length(); i++) {
            for (int j = 0; j < N; j++) {
                set.add(num[j].substring(num[0].length() - i));
            }
            if (set.size() == N) {
                System.out.println(i);
                break;
            }
            set.clear();
        }

    }
}
