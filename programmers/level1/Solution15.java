package programmers.level1;

import java.util.*;

//프로그래머스 Level1 대충 만든 자판
class Solution15 {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();

        for (String keys : keymap) {
            for (int i = 0; i < keys.length(); i++) {
                char key = keys.charAt(i);
                map.put(key, Math.min(map.getOrDefault(key,100), i + 1));
            }
        }

        int idx = 0;
        for (String target : targets) {
            int cnt = 0;
            for (int i = 0; i < target.length(); i++) {
                char c = target.charAt(i);
                int num = map.getOrDefault(c, -1);
                if (num == -1) {
                    cnt = -1;
                    break;
                }
                cnt += num;
            }
            answer[idx] = cnt;
            idx++;
        }
        return answer;
    }
}