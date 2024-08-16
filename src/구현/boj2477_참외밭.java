package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2477_참외밭 {
    /*
    알고리즘적(?)으로 접근하기 위한 고민,,,

    큰 사각형의 가장 긴 가로 옆 두 세로의 차이가 작은 사각형의 세로
    큰 사각형의 가장 긴 세로 옆 두 가로의 차이가 작은 사각형의 가로
     */
    static int K; // 1m2의 넓이에 자라는 참외의 개수
    static int[] side = new int[6];

    static int width = 0;
    static int height = 0;

    static int widthIdx;
    // 가장 긴 가로변 길이의 idx, 양 옆 세로의 차가 작은 사각형의 세로 길이
    static int heightIdx;
    // 가장 긴 세로변 길이의 idx, 양 옆 가로의 차가 작은 사각형 가로 길이

    static int smallWidth;
    static int smallHeight;

    static int area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            side[i] = len;

            // 동쪽은 1, 서쪽은 2, 남쪽은 3, 북쪽은 4
            if (dir <= 2 && width < side[i]) { // x축 이동
                width = side[i];
                widthIdx = i;
            } else if (2 < dir && height < side[i]) { // y축 이동
                height = side[i];
                heightIdx = i;
            }

        }

        // 작은 사각형
        if (widthIdx == 5) {
            smallHeight = Math.abs(side[4] - side[0]);
        } else if (widthIdx == 0) {
            smallHeight = Math.abs(side[5] - side[1]);
        } else {
            smallHeight = Math.abs(side[widthIdx - 1] - side[widthIdx + 1]);
        }

        if (heightIdx == 5) {
            smallWidth = Math.abs(side[4] - side[0]);
        } else if (heightIdx == 0) {
            smallWidth = Math.abs(side[1] - side[5]);
        } else {
            smallWidth = Math.abs(side[heightIdx + 1] - side[heightIdx - 1]);
        }

        area = (width * height) - (smallWidth * smallHeight);

        System.out.println(area * K);
    }
}
