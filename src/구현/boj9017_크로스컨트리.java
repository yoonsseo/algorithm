package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;


public class boj9017_크로스컨트리 {
    /*
    팀별 인원 수가 6명인지 먼저 확인하고 점수를 부여했어야 한다

    5번째 선수의 점수를 비교할 때
    5번째 선수들만의 점수를 비교하는 것이 아니라
    앞 네 선수의 점수합이 가장 작은 팀들의 5번째 선수의 점수를 비교해야 한다
    1
    21
    1 2 3 3 1 3 2 4 1 1 3 5 5 5 5 5 5 1 3 3 1
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());// 선수 수
            int[] rank = new int[N]; // 등수 별 해당 팀
            Map<Integer, Integer> team = new HashMap<>(); // 팀 별 인원 수 체크
            List<Integer> valid = new ArrayList<>(); // 인원 수가 6명인 팀
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                rank[j] = Integer.parseInt(st.nextToken());
                if (team.get(rank[j]) != null) { // 이미 있는 팀
                    int v = team.get(rank[j]) + 1;
                    team.replace(rank[j], v);
                    if (v == 6) {
                        valid.add(rank[j]);
                    }
                } else { // 새로운 팀
                    team.put(rank[j], 1);
                }
            }

            int num = 1;
            int[] score = new int[N];
            team = new HashMap<>(); // 4등까지 체크 위함
            Map<Integer, Integer> sum = new HashMap<>(); // 팀 별 4등까지 점수 합
            Map<Integer, Integer> fifth = new HashMap<>(); // 5등의 팀 이름과 점수 저장
            for (int j = 0; j < N; j++) {
                if (valid.contains(rank[j])) {
                    score[j] = num++;
                    if (team.get(rank[j]) != null) { // 이미 있는 팀
                        int v = team.get(rank[j]) + 1;
                        team.replace(rank[j], v);
                        if (v <= 4) {
                            int s = sum.get(rank[j]) + score[j];
                            sum.replace(rank[j], s);
                        }
                        if (v == 5) {
                            fifth.put(rank[j], score[j]);
                        }
                    } else { // 새로운 팀
                        team.put(rank[j], 1);
                        sum.put(rank[j], score[j]);
                    }
                }
            }

            // 점수로 팀 정렬
            List<Map.Entry<Integer, Integer>> sortedScore = new ArrayList<>(sum.entrySet());
            sortedScore.sort(Comparator.comparingInt(Map.Entry::getValue));

            if (1 < sortedScore.size() && // 팀이 하나 이상이고 동점인 경우
                    sortedScore.get(0).getValue().equals(sortedScore.get(1).getValue())) {
                int lowestScore = sortedScore.get(0).getValue();
                int lowestFifthScoreTeam = sortedScore.get(0).getKey();
                int fifthScore = fifth.get(lowestFifthScoreTeam);
                for (int j = 0; j < sortedScore.size(); j++) {
                    if (sortedScore.get(j).getValue().equals(lowestScore) &&
                            fifth.get(sortedScore.get(j).getKey()) < fifthScore) {
                        lowestFifthScoreTeam = sortedScore.get(j).getKey();
                        fifthScore = fifth.get(lowestFifthScoreTeam);
                    }
                }
                System.out.println(lowestFifthScoreTeam);
            } else { // 6명으로 인정되는 팀이 하나인 경우 OR 동점 없음
                System.out.println(sortedScore.get(0).getKey());
            }

        } // T
    } // psvm
}
