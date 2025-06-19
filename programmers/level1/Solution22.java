package programmers.level1;

import java.util.*;

class Solution22 {
    public int[] solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            if (q.size() < k) {
                q.offer(score[i]);
            } else {
                if (q.peek() < score[i]) {
                    q.poll();
                    q.offer(score[i]);
                }
            }
            answer.add(q.peek());
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}