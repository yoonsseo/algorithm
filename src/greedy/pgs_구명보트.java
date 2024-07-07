package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pgs_구명보트 {
    static int[] people;
    static int limit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        input = input.substring(1, input.length() - 1);
        String[] stringPeople = input.split(", ");
        people = new int[stringPeople.length];
        for (int i = 0; i < stringPeople.length; i++) {
            people[i] = Integer.parseInt(stringPeople[i]);
        }

        limit = Integer.parseInt(br.readLine());

        System.out.println(solution(people, limit));
    }

    static int solution(int[] people, int limit) {
        int answer = 0;
        int idx = 0;

        Arrays.sort(people);
        for (int i = people.length - 1; i >= idx; i--) {
            if (people[i] + people[idx] <= limit) {
                idx++;
                answer++;
            } else {
                answer++;
            }
        }

        return answer;
    }

}
