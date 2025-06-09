package programmers.level1;

import java.util.*;

//프로그래머스 Level1 추억 점수
class Solution11 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        int[] answer = new int[photo.length];
        Map<String, Integer> score = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            score.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                sum += score.getOrDefault(photo[i][j], 0);
            }
            answer[i] = sum;
        }
        return answer;
    }
}