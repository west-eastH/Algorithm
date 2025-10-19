package programmers.kit.hash;

import java.util.*;

//프로그래머스 알고리즘 고득점 Kit 의상
class Solution01 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }

        int result = 1;
        for (int cnt : map.values()) {
            result *= cnt;
        }
        result -= 1;
        return result;
    }
}