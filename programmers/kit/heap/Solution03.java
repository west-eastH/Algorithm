package programmers.kit.heap;

import java.util.*;

class Solution03 {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (cmd.equals("I")) {
                min.offer(num);
                max.offer(num);
            } else {
                if (!min.isEmpty() && num == -1) {
                    max.remove(min.poll());
                } else if (!max.isEmpty() && num == 1) {
                    min.remove(max.poll());
                }
            }
        }
        if (min.isEmpty() && max.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{max.poll(), min.poll()};
    }
}