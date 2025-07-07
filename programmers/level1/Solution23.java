package programmers.level1;

//프로그래머스 Level1 기사단원의 무기
class Solution23 {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] dp = new int[number + 1];

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    dp[i]++;
                    if (j * j != i) {
                        dp[i]++;
                    }
                }
            }
        }

        for (int i = 1; i <= number; i++) {
            if (dp[i] > limit) {
                dp[i] = power;
            }
            answer += dp[i];
        }

        return answer;
    }
}