package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pgs_옹알이2 {
    // "aya", "ye", "woo", "ma" 만 발음 가능
    static String[] word = {"aya", "ye", "woo", "ma"};
    static String[] wordChange = {"!", "@", "#", "$"};

    static String[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine();
        inputString = inputString.substring(2, inputString.length() - 2);
        input = inputString.split("\", \"");

        System.out.println(solution(input));
    }

    static int solution(String[] babbling) {
        int answer = 0;

        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < word.length; j++) {
                if (babbling[i].contains(word[j])) {
                    babbling[i] = babbling[i].replace(word[j], wordChange[j]);
                }
            }

            if (onlyWords(babbling[i])) {
                answer++;
            }
        }

        return answer;
    }

    static boolean onlyWords(String checkWord) {
        boolean flag = false;
        String prev = String.valueOf(checkWord.charAt(0));
        String now;

        for (int i = 0; i < checkWord.length(); i++) {
            if (String.valueOf(checkWord.charAt(i)).equals(wordChange[0])
                    || String.valueOf(checkWord.charAt(i)).equals(wordChange[1])
                    || String.valueOf(checkWord.charAt(i)).equals(wordChange[2])
                    || String.valueOf(checkWord.charAt(i)).equals(wordChange[3])
            ) {
                flag = true;
            } else {
                return false;
            }
        }

        for (int i = 1; i < checkWord.length(); i++) {
            now = String.valueOf(checkWord.charAt(i));
            if (prev.equals(now)) {
                return false;
            }
            prev = now;
        }

        return flag;
    }
}
