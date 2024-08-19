package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj30804_과일탕후루 {
    static int N; // 과일 개수
    static int[] fruit = new int[10]; // 과일 종류마다 몇 개 있는지
    static int[] skewer; // 과일 꼬치
    static int allKind = 0; // 총 과일 종류 개수

    static int max = 0;

    static int start = 0;
    static int end = 0;
    static boolean flag = true; // 구간 내 과일 종류가 두 개 이하

    static int[] pFruit = new int[10]; // 구간 내 과일 종류
    static int pKind = 0; // 구간 내 과일 종류 개수
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        skewer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            if (fruit[idx] == 0) { // 새로운 과일
                allKind++;
            }
            fruit[idx]++;
            skewer[i] = idx;
        }

        if (allKind == 1) { // 한 종류의 과일만 있는 경우
            System.out.println(N);
            return;
        }

        while (start <= end && end < N) {
            if (pKind < 2) {
                if (pFruit[skewer[end]] == 0) { // 해당 과일 구간 내 처음 등장
                    pKind++;
                }
                pFruit[skewer[end]]++;
                count++;
                max = Math.max(max, count);
                end++;
            } else if (pKind == 2) {
                if (pFruit[skewer[end]] != 0) { // 이미 구간 내 존재하는 과일 종류만 추가 가능
                    pFruit[skewer[end]]++;
                    count++;
                    max = Math.max(max, count);
                    end++;
                } else { // 새로운 과일
                    pFruit[skewer[start]]--;
                    if (pFruit[skewer[start]] == 0) {
                        pKind--;
                    }
                    start++;
                    count--;
                }
            } else { // 2 < pKind
                pFruit[skewer[start]]--;
                if (pFruit[skewer[start]] == 0) {
                    pKind--;
                }
                start++;
                count--;
            }
        }

        System.out.println(max);
    }

    private static void twoPointer(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (pFruit[skewer[i]] != 0) { // 해당 과일이 꼬치에 있음
                count++;
                max = Math.max(max, count);
            } else { // 해당 과일 처음 등장
                pFruit[skewer[i]]++;
                pKind++;
                if (pKind <= 2) {
                    count++;
                    max = Math.max(max, count);
                } else { // 과일 세 종류 이상
                    flag = false;
                    return;
                }
            }
        }
    }
}
