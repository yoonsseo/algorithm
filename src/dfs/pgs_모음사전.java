package dfs;

public class pgs_모음사전 {
    class Solution {
        static String[] alph = {"A", "E", "I", "O", "U"};
        static int count = 0;
        static int answer = 0;
        static String target;

        public int solution(String word) {
            target = word;

            dfs("");

            return answer;
        }

        private void dfs(String term) {
            if (term.equals(target)) {
                answer = count;
            }

            if (term.length() == 5) {
                return;
            }

            for (int i = 0; i < 5; i++) {
                count++;
                dfs(term + alph[i]);
            }

        }
    }
}
