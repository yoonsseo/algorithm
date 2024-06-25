package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class boj1427_소프트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        //reverseOrder() : 큰수 -> 작은수 정렬해주는 메서드를 쓰기 위해 Integer 배열 사용
        Integer[] A = new Integer[input.length()];

        for(int i = 0; i < A.length; i++) {
            A[i] = input.charAt(i) - '0';
        }

        Arrays.sort(A, Collections.reverseOrder()); //큰수 -> 작은수로 정렬

        for(int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }
    }
}
