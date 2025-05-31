package programmers.level1;

//프로그래머스 Level1 유연근무제
class Solution02 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int sat = startday < 6 ? 6 - startday : 0;
        int sun = startday < 6 ? sat + 1 : startday == 6 ? 1 : 6;
        int[] count = new int[schedules.length];

        for (int i = 0; i < schedules.length; i++) {
            for (int j = 0; j < 7; j++) {
                if (j != sat && j != sun) {
                    int time = 0;
                    if (schedules[i] % 100 < 50) {
                        time = schedules[i] + 10;
                    } else {
                        time += (schedules[i] / 100 + 1) * 100;
                        time += schedules[i] % 50;
                    }
                    if (timelogs[i][j] <= time) {
                        count[i]++;
                    }
                }
            }
            if (count[i] == 5) answer++;
        }

        return answer;
    }
}