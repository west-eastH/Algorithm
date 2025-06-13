package programmers.level1;

//프로그래머스 Level1 둘만의 암호
class Solution17 {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            char cur = c;
            int moved = 0;

            while (moved < index) {
                cur++;

                if (cur > 'z')
                    cur = 'a';

                if (skip.indexOf(cur) == -1) {
                    moved++;
                }
            }
            sb.append(cur);
        }

        return sb.toString();
    }
}