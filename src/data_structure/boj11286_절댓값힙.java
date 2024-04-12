package data_structure;

import java.util.PriorityQueue;
import java.util.Scanner;

public class boj11286_절댓값힙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 절댓값이 같으면 작은 수(음수)가 앞에 오도록, 절댓값이 다르면 절댓값이 작은 수가 앞에 오도록
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(((o1, o2) -> {
            int ab1 = Math.abs(o1);
            int ab2 = Math.abs(o2);
            return ab1 == ab2 ? Integer.compare(o1, o2) : Integer.compare(ab1, ab2);
        }));

        for (int i = 0; i < N; i++) {
            int value = sc.nextInt();
            if (value != 0) {
                minHeap.offer(value);
            } else { // 0이 들어오면
                if (minHeap.isEmpty()) { // 0이 들어오는데 비어있다
                    System.out.println("0");
                } else { // 0이 들어오는데 값이 있음
                    System.out.println(minHeap.remove());
                }
            }

        }
    }
}
