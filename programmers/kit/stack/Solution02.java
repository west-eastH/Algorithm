package programmers.kit.stack;

import java.util.LinkedList;
import java.util.Queue;

class Solution02 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int sum = 0;
        int answer = 0;
        int cur = 0;
        Queue<Integer> q = new LinkedList<>();

        while (cur < truck_weights.length) {
            if (q.size() == bridge_length) {
                int n = q.poll();
                sum -= n;
            }

            if (q.isEmpty() || sum + truck_weights[cur] <= weight) {
                q.offer(truck_weights[cur]);
                sum += truck_weights[cur];
                cur++;
                answer++;
            } else {
                q.offer(0);
                answer++;
            }
        }
        answer += bridge_length;
        return answer;
    }
}