package programmers.level1;

//프로그래머스 Level1 옹알이 (2)
class Solution25 {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String str : babbling) {
            if (check(str))
                answer++;
        }
        return answer;
    }

    public static boolean check(String str) {
        int idx = 0;
        String prev = "PREV";
        while (idx < str.length() - 1) {

            String temp = str.substring(idx);
            if (!temp.startsWith(prev)) {
                if (temp.startsWith("ye") || temp.startsWith("ma")) {
                    prev = str.substring(idx, idx + 2);
                    idx += 2;
                } else if (temp.startsWith("aya") || temp.startsWith("woo")) {
                    prev = str.substring(idx, idx + 3);
                    idx += 3;
                }
                else return false;
            }
            else
                return false;
        }
        if (idx < str.length())
            return false;
        return true;
    }
}