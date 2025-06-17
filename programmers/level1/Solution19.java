package programmers.level1;

class Solution19 {
    public int solution(String t, String p) {
        int answer = 0;
        int size = p.length();
        Long num = Long.parseLong(p);

        for (int i = 0; i < t.length() - size + 1; i++) {
            if (toInt(t, i, i + size) <= num)
                answer++;
        }
        return answer;
    }

    public static Long toInt(String n, int start, int end) {
        return Long.parseLong(n.substring(start, end));
    }
}