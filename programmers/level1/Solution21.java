package programmers.level1;

//프로그래머스 Level1 문자열 나누기
class Solution21 {
    public int solution(String s) {
        int answer = 0;
        char[] str = s.toCharArray();
        int sizeA = 1;
        int sizeB = 0;
        char start = str[0];

        for (int i = 1; i < str.length; i++) {
            if (sizeA == 0) {
                start = str[i];
            }
            if (str[i] == start) {
                sizeA++;
            } else {
                sizeB++;
            }
            if (sizeA == sizeB) {
                sizeA = 0;
                sizeB = 0;
                answer++;
            }
        }
        if (sizeA != sizeB)
            answer++;
        return answer;
    }
}