package programmers.level1;

//프로그래머스 Level1 덧칠하기
class Solution14 {
    public int solution(int n, int m, int[] section) {

        int answer = 0;
        int painted = 0;

        for (int pos : section) {
            if (painted < pos) {
                answer++;
                painted = pos + m - 1;
            }
        }

        return answer;
    }
}