package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class boj16922_로마숫자만들기 {
    /*
    HashSet을 사용하면 시간초과
    1 <= N <= 20 이므로 20 * 50 = 1000 의 boolean 배열을 사용해
    해당 인덱스가 나온 적이 있는지 판별

    dfs의 반복문을 i부터 시작하도록 하여 이전에 선택했던 조합은
    다시 계산하지 않을 수 있도록 수정

    ArrayList를 이용해 로마 숫자 값을 N개 저장하고 합을 구했는데
    sum값을 넘기도록 수정
     */
    static int[] romanNum = {1, 5, 10, 50}; // 중복 선택 가능
    static int N; // N개 선택
    static int count = 0;
    static boolean[] visited = new boolean[10002];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(0, 0);

        System.out.println(answer);

    }

    private static void dfs(int now, int sum) {
        if (count == N) {
            if (!visited[sum]) {
                visited[sum] = true;
                answer++;
            }
            return;
        }

        for (int i = now; i < 4; i++) {
            count++;
            dfs(i, sum + romanNum[i]);
            count--;
        }
    }
}
