package programmers.kit.greedy;

import java.util.*;

class Solution02 {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            while (!stack.isEmpty() && number.charAt(i) > stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(number.charAt(i));
        }
        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}