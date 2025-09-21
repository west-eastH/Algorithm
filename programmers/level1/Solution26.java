package programmers.level1;

//프로그래머스 Level1 같은 숫자는 싫

import java.util.*;

public class Solution26 {
    public int[] solution(int []arr) {
        int[] answer;

        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
            if (s.isEmpty() || s.peek() != arr[i]) {
                s.push(arr[i]);
                System.out.print(arr[i] + " ");
            }
        }

        answer = new int[s.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = s.pop();
        }
        return answer;
    }
}