package 구현;

public class pgs_카펫 {
    class Solution {
        static int B;
        static int Y;

        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            B = brown;
            Y = yellow;

        /*
         갈색 = (가로 + 세로 - 1) + (가로 - 1) + (세로 - 2)
             = (가로 + 세로) * 2 - 4
         노랑 = (가로 - 2) * (세로 - 2)
         */

            int w = brown / 2;
            int h = (brown + 4) / 2  - w;

            while (!checkYellow(w, h)) {
                w--;
                h++;
            }

            answer[0] = w;
            answer[1] = h;
            return answer;
        }

        private boolean checkBrown(int w, int h) {
            return B == (w + h) * 2 - 4;
        }

        private boolean checkYellow(int w, int h) {
            return Y == (w - 2) * (h - 2);
        }
    }
}
