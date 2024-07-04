package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj30892_상어키우기 {
    // 데크나 큐와 스택을 이용한다

    static int N; // 존재하는 상어 수
    static int K; // 먹을 수 있는 상어 수
    static long T; // 최초의 상어 크기

    static long shark = 0; // 현재 상어의 크기

    static Stack<Long> smallShark = new Stack<>();
    static Queue<Long> bigShark = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        T = Long.parseLong(st.nextToken());
        shark = T;

        long[] sharks = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sharks[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(sharks);
        for (int i = 0; i < N; i++) {
            if (sharks[i] < T) {
                smallShark.push(sharks[i]);
            } else {
                bigShark.offer(sharks[i]);
            }
        }

        for (int i = 0; i < K; i++) {
            if (smallShark.empty()) {
                System.out.println(shark);
                return;
            }
                shark += smallShark.pop();
            while (bigShark.peek() != null && bigShark.peek() < shark) {
                smallShark.push(bigShark.poll());
            }
        }

        System.out.println(shark);
    }

}
