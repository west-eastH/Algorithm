package programmers.level2;

import java.util.*;

//프로그래머스 Level2 서버 증설 횟수
class Solution02 {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] time = new int[25];
        Arrays.fill(time, m - 1);

        for (int i = 0; i < 24; i++) {

            if (players[i] > time[i]) {
                int cur = time[i] - (m - 1);
                int serverCnt = (players[i] - cur) / m;
                answer += serverCnt;
                for (int j = 0; j < k; j++) {
                    if (i + j == 24)
                        break;
                    time[i + j] += (serverCnt * m);
                }
            }
        }
        return answer;
    }
}