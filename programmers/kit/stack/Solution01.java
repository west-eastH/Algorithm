package programmers.kit.stack;

import java.util.*;

class Solution01 {

    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> pro = new LinkedList<>();
        Queue<Integer> spe = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            pro.offer(progresses[i]);
            spe.offer(speeds[i]);
        }

        int day = 1;

        while (!pro.isEmpty()) {

            int cnt = 0;
            int cur = pro.peek() + (day * spe.peek());

            while (cur >= 100) {
                pro.poll();
                spe.poll();
                cnt++;

                if (!pro.isEmpty()) {
                    cur = pro.peek() + (day * spe.peek());
                } else {
                    break;
                }
            }
            if (cnt != 0) {
                result.add(cnt);
            }
            day++;
        }

        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}