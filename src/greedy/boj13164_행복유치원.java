package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj13164_행복유치원 {
    /*
    인접 행렬값 간의 차를 모두 구해서 최소값을 갖는 값의 개수만큼 더하기
     */

    static int N;
    static int K;

    static int[] H;
    static int[] diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        H = new int[N];
        diff = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            H[i] = Integer.parseInt(st.nextToken());
            if (1 <= i) {
                diff[i - 1] = H[i] - H[i - 1];
            }
        }

        Arrays.sort(diff);

        int total = 0;
        for (int i = 0; i < N - K; i++) {
            total += diff[i];
        }

        System.out.println(total);
    }
}
