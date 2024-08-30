package 구현;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class pgs_베스트앨범 {
    /*
    맵 안에 또 맵 넣어 푸는 아이디어
     */

    class Solution {
        public List<Integer> solution(String[] genres, int[] plays) {
            List<Integer> answer = new ArrayList<>();

            Map<String, Integer> genreMap = new HashMap<>();
            Map<String, Map<Integer, Integer>> playMap = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                if (genreMap.get(genres[i]) != null) { // 이미 존재
                    genreMap.replace(genres[i], genreMap.get(genres[i]) + plays[i]);
                    playMap.get(genres[i]).put(i, plays[i]);
                } else {
                    genreMap.put(genres[i], plays[i]);

                    Map<Integer, Integer> map = new HashMap<>();
                    map.put(i, plays[i]);
                    playMap.put(genres[i], map);
                }
            }

            List<String> genreList = new ArrayList<>(genreMap.keySet());
            genreList.sort((o1, o2) -> genreMap.get(o2) - genreMap.get(o1));


            for (int i = 0; i < genreList.size(); i++) {
                Map<Integer, Integer> map = playMap.get(genreList.get(i));
                List<Integer> playList = new ArrayList<>(map.keySet());

                if (2 <= map.size()) {
                    playList.sort((o1, o2) -> map.get(o2) - map.get(o1));
                    answer.add(playList.get(0));
                    answer.add(playList.get(1));
                } else {
                    answer.add(playList.get(0));
                }
            }

            return answer;
        }
    }
}
