package 문자열;

public class pgs_JadenCase문자열만들기 {
    class Solution {
        // 공백 문자가 연속해서 나올 수 있다는 문구!
        // 공백을 없애버리면 안 된다!
        public String solution(String s) {
            String answer = "";
            StringBuilder sb = new StringBuilder();

            s = s.toLowerCase();
            for (int i = 0; i < s.length(); i++) {
                if (i == 0) {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                } else if (s.charAt(i - 1) == ' ') {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                } else {
                    sb.append(s.charAt(i));
                }
            }

        /*
        for (String word : words) {
            // System.out.println(word);
            if (word.length() > 0 && word.charAt(0) != ' ') {
                sb.append(word.substring(0, 1).toUpperCase());
                sb.append(word.substring(1));
                sb.append(" ");
            } else if ()
        }

        sb.deleteCharAt(sb.length() - 1);
        */

            answer = sb.toString();

            return answer;
        }
    }
}
