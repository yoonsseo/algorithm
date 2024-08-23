package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj31428_엘리스트랙매칭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] friends = new char[N];
        for (int i = 0; i < N; i++) {
            friends[i] = st.nextToken().charAt(0);
        }

        char hellobit = br.readLine().charAt(0);
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (friends[i] == hellobit) {
                count++;
            }
        }

        System.out.println(count);
    }
}
