package programmers.kit.hash;

import java.util.*;

//프로그래머스 알고리즘 고득점 Kit 베스트 앨범
class Solution02 {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> count = new HashMap<>();
        Map<String, Map<Integer, Integer>> music = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);
            Map<Integer, Integer> map = music.getOrDefault(genres[i], new HashMap<>());
            map.put(i, plays[i]);
            music.put(genres[i], map);
        }

        List<String> keys = new ArrayList(count.keySet());
        Collections.sort(keys, (s1, s2) -> count.get(s2) - count.get(s1));

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < keys.size(); i++) {
            Map<Integer, Integer> map = music.get(keys.get(i));

            List<Integer> list = new ArrayList<>(map.keySet());
            Collections.sort(list, (s1, s2) -> map.get(s2) - map.get(s1));

            result.add(list.get(0));

            if (list.size() > 1) {
                result.add(list.get(1));
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
