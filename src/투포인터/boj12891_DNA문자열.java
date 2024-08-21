package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj12891_DNA문자열 {
    /*
    만들 수 있는 비밀번호 종류의 수 출력
    단 부분문자열이 등장하는 위치가 다르다면 부분문자열이 같다고 하더라도 다른 문자열로 취급
    종료 조건 찾기가 어려웠다
     */
    static int S;
    static int P;
    static String dna;
    static int[] min = new int[4];

    static int[] count = new int[4];
    static int start;
    static int end;
    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
        P = Integer.parseInt(st.nextToken()); // 비밀번호 길이

        dna = br.readLine();

        // 부분문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            min[i] = Integer.parseInt(st.nextToken());
        }

        start = 0;
        end = P - 1;

        for (int i = 0; i < P; i++) {
            count[getIdx(i)]++;
        }

        while (end <= S - 1) {
            if (checkMin()) {
                total++;
            }
            if (end == S - 1) {
                break;
            }
            count[getIdx(start)]--;
            start++;
            end++;
            count[getIdx(end)]++;
        }

        System.out.println(total);
    }

    private static boolean checkMin() {
        return (min[0] <= count[0] && min[1] <= count[1] && min[2] <= count[2] && min[3] <= count[3]);
    }

    private static int getIdx(int i) {
        switch (dna.charAt(i)) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
        }
        return 4;
    }
}
