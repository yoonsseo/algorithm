package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pgs_공원산책 {
    static String[][] map;
    static int X;
    static int Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputArray = br.readLine();
        inputArray = inputArray.substring(2, inputArray.length() - 2);
        String[] park = inputArray.split("\",\"");

        inputArray = br.readLine();
        inputArray = inputArray.substring(2, inputArray.length() - 2);
        String[] routes = inputArray.split("\",\"");

        System.out.println(Arrays.toString(solution(park, routes)));
    }

    static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        String op; // 이동 방향
        int n; // 이동 수
        int x = 0; // 현재 위치 x
        int y = 0; // 현재 위치 y

        X = park.length;
        Y = park[0].length();
        map = new String[X][Y];
        // S 또는 X 또는 O
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                map[i][j] = String.valueOf(park[i].charAt(j));
                if (map[i][j].equals("S")) {
                    x = i;
                    y = j;
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            op = String.valueOf(routes[i].charAt(0));
            n = Integer.parseInt(String.valueOf(routes[i].charAt(2)));
            AnswerDto answerDto = check(x, y, op, n);
            if (answerDto.flag) {
                x = answerDto.x;
                y = answerDto.y;
            } else {
                continue;
            }
        }

        answer[0] = x;
        answer[1] = y;

        return answer;
    }

    static AnswerDto check(int x, int y, String op, int n) {
        boolean flag = false;
        int dx = x;
        int dy =y;

        for (int i = 0; i < n; i++) {
            if (op.equals("N")) {
                dx--;
            } else if (op.equals("S")) {
                dx++;
            } else if (op.equals("W")) {
                dy--;
            } else { // op.equals("E")
                dy++;
            }

            if (!rangeCheck(dx, dy) || map[dx][dy].equals("X")) {
                flag = false;
                break;
            } else {
                flag = true;
            }
        }

        return new AnswerDto(flag, dx, dy);
    }

    static boolean rangeCheck(int x, int y) {
        return (0 <= x && x < X && 0 <= y && y < Y);
    }

    public static class AnswerDto {
        boolean flag;
        int x;
        int y;

        public AnswerDto(boolean flag, int x, int y) {
            this.flag = flag;
            this.x = x;
            this.y = y;
        }
    }

}
