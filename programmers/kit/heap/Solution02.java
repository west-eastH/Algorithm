package programmers.kit.heap;

import java.util.*;

class Work {
    int id;
    int start;
    int time;

    public Work(int id, int start, int time) {
        this.id = id;
        this.start = start;
        this.time = time;

    }
}

class Solution02 {
    public int solution(int[][] jobs) {

        PriorityQueue<Work> pq = new PriorityQueue<>((a, b) -> {
            if (a.time == b.time) {
                if (a.start == b.start) {
                    return a.id - b.id;
                }
                return a.start - b.start;
            }
            return a.time - b.time;
        });

        int cur = 0;
        int end = -1;
        boolean isRun = false;
        int cnt = 0;
        int sum = 0;

        while (true) {
            for (int i = 0; i < jobs.length; i++) {
                if (jobs[i][0] == cur) {
                    cnt++;
                    pq.offer(new Work(i, jobs[i][0], jobs[i][1]));
                }
            }
            if (cur == end) {
                isRun = false;
                if (pq.isEmpty() && cnt == jobs.length) {
                    break;
                }
            }

            if (!pq.isEmpty() && !isRun) {
                Work work = pq.poll();
                sum += cur + work.time - work.start;
                isRun = true;
                end = cur + work.time;
            }
            cur++;
        }

        return sum / jobs.length;
    }
}