package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1543_문서검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dic = br.readLine();
        String word = br.readLine();

        int count = 0;
        while (word.length() <= dic.length()) {
            int idx = dic.indexOf(word);
            if (idx == -1) { // 찾을 수 없으면
                break;
            } else {
                count++;
                dic = dic.substring(idx + word.length());
            }
        }

        System.out.println(count);
    }
}
