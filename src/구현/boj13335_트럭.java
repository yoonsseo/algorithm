package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class boj13335_트럭 {
    static int n; // 트럭 수
    static int w; // 다리 길이
    static int L; // 다리 최대 하중
    static Queue<Integer> trucks = new LinkedList<>(); // 트럭 별 무게 저장
    static int count = 0;
    static Queue<Integer> queue = new LinkedList<>(); // 다리 위에 있는 트럭

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks.offer(Integer.parseInt(st.nextToken()));
        }

        int weight = 0; // 현재 다리 하중
        for (int i = 0; i < w; i++) {
            queue.offer(0);
        }

        while (!queue.isEmpty()) { // 다리 위의 트럭이 없을 때까지
            count++;
            weight -= queue.poll(); // 트럭 무게 또는 0

            if (!trucks.isEmpty()) { // 트럭이 남아있으면
                if (weight + trucks.peek() <= L) { // 최대 하중을 넘지 않으면
                    weight += trucks.peek();
                    queue.offer(trucks.poll());
                } else { // 최대 하중을 넘으면
                    queue.offer(0);
                }
            }
        }

        System.out.println(count);
    }
}
