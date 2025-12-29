package programmers.kit.bruteForce;

import java.util.*;

class Solution02 {
    public int[] solution(int[] answers) {
        int[] cnt = new int[3];

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i % a.length]) {
                cnt[0]++;
            }
            if (answers[i] == b[i % b.length]) {
                cnt[1]++;
            }
            if (answers[i] == c[i % c.length]) {
                cnt[2]++;
            }
        }

        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));

        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < 3; i++) {
            if (max == cnt[i])
                arr.add(i + 1);
        }

        int[] answer = arr.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}