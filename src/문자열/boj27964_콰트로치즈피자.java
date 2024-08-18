package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj27964_콰트로치즈피자 {
    /*
    서로 다른 네 종류의 치즈!
    Cheese 로 끝나려면 문자열이 6 이상이어야 한다
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 토핑 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        Set<String> kind = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String topping = st.nextToken();
            if (6 <= topping.length() &&
                    topping.substring(topping.length() - 6, topping.length()).equals("Cheese") &&
                    !kind.contains(topping)) {
                kind.add(topping);
                count++;
                if (4 <= count) {
                    System.out.println("yummy");
                    return;
                }
            }
        }

        System.out.println("sad");
    }
}
