package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1713_후보추천하기 {
    /*
    우선 순우 큐의 우선 순위는 큐에 들어갈 때 정해지는 것 같아서
    size가 N이어서 큐에서 하나를 빼야할 때
    전체를 다 빼고 다시 넣어 우선순위를 다시 적용
     */
    static int N; // 사진 틀 개수
    static int M; // 학생 수

    static List<Integer> frame = new ArrayList<>();

    static Student[] students = new Student[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        PriorityQueue<Student> pQueue = new PriorityQueue<>();
        PriorityQueue<Student> temp = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int r = Integer.parseInt(st.nextToken());

            if (students[r] != null) {
                students[r].count++;
                if (students[r].count == 1) {
                    students[r].time = i;
                }
            } else {
                students[r] = new Student(r, i, 1);
            }

            if (!pQueue.contains(students[r])) {
                if (pQueue.size() == N) {
                    while (!pQueue.isEmpty()) {
                        temp.offer(pQueue.poll());
                    }
                    while (!temp.isEmpty()) {
                        pQueue.offer(temp.poll());
                    }
                    Student s = pQueue.poll();
                    s.count = 0;
                }
                pQueue.offer(students[r]);
            }
        }

        while (!pQueue.isEmpty()) {
            frame.add(pQueue.poll().no);
        }

        frame.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < frame.size(); i++) {
            sb.append(frame.get(i));
            sb.append(" ");
        }

        System.out.println(sb);
    }

    private static class Student implements Comparable<Student> {
        int no;
        int time;
        int count;

        public Student(int no, int time, int count) {
            this.no = no;
            this.time = time;
            this.count = count;
        }

        @Override
        public int compareTo(Student o) {
            if (this.count == o.count) {
                return this.time - o.time;
            } else {
                return this.count - o.count;
            }
        }
    }

}
