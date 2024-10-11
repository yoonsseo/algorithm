package 투포인터;

public class pgs_연속된부분수열의합 {
    class Solution {
        public int[] solution(int[] sequence, int k) {
            int[] answer = {0, sequence.length};

            int start = 0;
            int end = 1;
            int sum = sequence[0];

            while (start < end) {
                if (sum == k) {
                    if ((end - 1) - start < answer[1] - answer[0]) {
                        answer[0] = start;
                        answer[1] = end - 1;
                    }
                    sum -= sequence[start];
                    start++;
                } else if (sum < k && end < sequence.length) {
                    sum += sequence[end];
                    end++;
                } else if (k < sum) {
                    sum -= sequence[start];
                    start++;
                } else {
                    break;
                }
            }

            return answer;
        }
    }
}
