package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pgs_마법의엘리베이터 {
    /*
    5가 연속으로 나오는 경우, 다음 자리 수가 5 이상일 경우 올라가고, 4 이하인 경우 내려가야 한다
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int storey = Integer.parseInt(br.readLine());
        System.out.println(solution(storey));
    }

    private static int solution(int storey) {
        int answer = 0;

        int digit = (int) Math.log10(storey) + 1; // 자릿수 4    2450
        int i = 1;
        while (storey != 0) {
            int sq = (int) Math.pow(10, i); // 100   2450
            int R = storey % sq; // 50
            int roundF = (int) Math.pow(10, i - 1); // 10
            int roundC = (int) Math.pow(10, i + 1); // 1000

            if (R / roundF == 5 && i != digit) { // 그 다음 자리수까지 고려!
                if ((storey - R) % roundC / sq <= 4) {
                    storey -= R;
                    answer += (R / roundF);
                } else {
                    storey += (sq - R);
                    answer += ((sq - R) / roundF);
                }
            } else if (5 * roundF < R) {
                storey += (sq - R);
                answer += ((sq - R) / roundF);
            } else {
                storey -= R;
                answer += (R / roundF);
            }

            i++;
        }

        return answer;
    }
}
