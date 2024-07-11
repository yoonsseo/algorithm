package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj20125_쿠키의신체측정 {
    static int N; // 좌표 길이
    static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new String[N][N];

        boolean head = false; // 머리 찾았는지
        int x = 0, y = 0; // 심장 좌표
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (!head && input.contains("*")) {
                head = true;
                x = i + 1;
                y = input.indexOf("*");
            }
            String[] split = input.split("");
            arr[i] = split;
        }

        int leftArm = countLeftArm(x, y);
        int rightArm = countRightArm(x, y);
        int body = countBody(x, y);
        int leftLeg = countLeftLeg(x, y, body);
        int rightLeg = countRightLeg(x, y, body);

        System.out.println((x + 1) + " " + (y + 1)); // 문제의 좌표는 (0, 0)이 아니라 (1, 1)로 시작
        System.out.println(leftArm + " " + rightArm + " " + body + " " + leftLeg + " " + rightLeg);
    }

    private static int countLeftArm(int x, int y) {
        int leftArm = 0;
        y -= 1;

        while (0 <= y && arr[x][y].equals("*")) {
            leftArm++;
            y--;
        }

        return leftArm;
    }

    private static int countRightArm(int x, int y) {
        int rightArm = 0;
        y += 1;

        while (y < N && arr[x][y].equals("*")) {
            rightArm++;
            y++;
        }

        return rightArm;
    }
    private static int countBody(int x, int y) {
        int body = 0;
        x += 1;

        while (x < N && arr[x][y].equals("*")) {
            body++;
            x++;
        }

        return body;
    }
    private static int countLeftLeg(int x, int y, int body) {
        int leftLeg = 0;
        x += body + 1;
        y -= 1;

        while (x < N && arr[x][y].equals("*")) {
            leftLeg++;
            x++;
        }

        return leftLeg;
    }
    private static int countRightLeg(int x, int y, int body) {
        int rightLeg = 0;
        x += body + 1;
        y += 1;

        while (x < N && arr[x][y].equals("*")) {
            rightLeg++;
            x++;
        }

        return rightLeg;
    }


}
