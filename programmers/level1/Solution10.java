package programmers.level1;

import java.util.*;


//프로그래머스 Level1 달리기 경주
class Solution10 {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> name = new HashMap<>();
        Map<Integer, String> num = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            name.put(players[i], i + 1);
            num.put(i + 1, players[i]);
        }

        for (String str : callings) {
            int rank = name.get(str);
            String otherPlayer = num.get(rank - 1);

            name.put(str, rank - 1);
            name.put(otherPlayer, rank);

            num.put(rank, otherPlayer);
            num.put(rank - 1, str);
        }

        for (int i = 1; i < players.length + 1; i++) {
            answer[i - 1] = num.get(i);
        }
        return answer;
    }
}