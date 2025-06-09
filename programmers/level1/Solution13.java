package programmers.level1;

import java.util.*;

//프로그래머스 Level1 바탕화면 정리
class Solution13 {
    public int[] solution(String[] wallpaper) {
        int[] answer;
        int minH = Integer.MAX_VALUE;
        int minW = Integer.MAX_VALUE;
        int maxH = Integer.MIN_VALUE;
        int maxW = Integer.MIN_VALUE;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minH = Math.min(minH, i);
                    minW = Math.min(minW, j);
                    maxH = Math.max(maxH, i);
                    maxW = Math.max(maxW, j);
                }
            }
        }
        answer = new int[]{minH, minW, maxH + 1, maxW + 1};
        return answer;
    }
}