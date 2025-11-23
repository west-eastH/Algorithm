package programmers.kit.heap;

import java.util.*;

class Solution01 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : scoville) {
            pq.offer(i);
        }

        while (pq.peek() < K && pq.size() >= 2) {

            int a = pq.poll();
            int b = pq.poll();

            pq.offer(a + b * 2);
            answer++;
        }

        if (pq.poll() < K) {
            return -1;
        }

        return answer;
    }
}