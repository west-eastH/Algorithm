package programmers.level1;

import java.util.*;

class Solution28 {
    public String solution(String[] survey, int[] choices) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            String temp = survey[i];
            int score = Math.abs(choices[i] - 4);

            if (choices[i] < 4) {
                map.put(temp.charAt(0), map.getOrDefault(temp.charAt(0), 0) + score);
            } else {
                map.put(temp.charAt(1), map.getOrDefault(temp.charAt(1), 0) + score);
            }
        }

        char[] arr = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i+=2) {
            if (map.getOrDefault(arr[i], 0) < map.getOrDefault(arr[i + 1], 0)) {
                sb.append(arr[i + 1]);
            } else {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }
}