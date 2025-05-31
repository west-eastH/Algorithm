package programmers.level1;

//프로그래머스 Level1 지폐 접기
class Solution04 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int walletMax = Math.max(wallet[0], wallet[1]);
        int walletMin = Math.min(wallet[0], wallet[1]);
        int billMax = Math.max(bill[0], bill[1]);
        int billMin = Math.min(bill[0], bill[1]);

        while (billMax > walletMax || billMin > walletMin) {
            int temp = billMax / 2;
            billMax = Math.max(temp, billMin);
            billMin = Math.min(temp, billMin);
            answer++;
        }
        return answer;
    }
}