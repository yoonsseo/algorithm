package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1244_스위치켜고끄기 {
    /*
    출력 형식 조건이 있었음!
    스위치의 상태를 1번 스위치에서 시작하여 마지막 스위치까지 한 줄에 20개씩 출력한다.
    예를 들어 21번 스위치가 있다면 이 스위치의 상태는 둘째 줄 맨 앞에 출력한다.
     */
    static int N; // 스위치 개수
    static int[] outlet; // 스위치 상태 배열
    static int T; // 학생 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        outlet = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            outlet[i] = Integer.parseInt(st.nextToken());
        }

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 성별 남자1 여자2
            int n = Integer.parseInt(st.nextToken()); // 받은 숫자

            if (s == 1) {
                male(n);
            } else {
                female(n);
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(outlet[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }

    private static void male(int n) {
        int i = 1; // 학생이 받은 수의 배수 계산 위함
        while (n * i <= N) {
            toggle(n * i);
            i++;
        }
    }

    private static void female(int n) {
        toggle(n);
        int i = 1; // 좌우 대칭 개수
        while (0 < n - i && n + i <= N) {
            if (outlet[n - i] == outlet[n + i]) {
                toggle(n - i);
                toggle(n + i);
                i++;
            } else {
                break;
            }
        }
    }

    private static void toggle(int n) {
        if (outlet[n] == 0) {
            outlet[n] = 1;
        } else {
            outlet[n] = 0;
        }
    }
}
