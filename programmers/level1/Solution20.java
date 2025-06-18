package programmers.level1;

import java.util.*;

//프로그래머스 Level1 가장 가까운 같은 글자
class Solution20 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        char[] carr = s.toCharArray();
        for (int i = 0; i < carr.length; i++) {
            char c = carr[i];
            if (map.getOrDefault(c, -1) == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - map.get(c);
            }
            map.put(c, i);
        }
        return answer;
    }
}