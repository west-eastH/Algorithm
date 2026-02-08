package programmers.kit.bruteForce;

import java.util.*;

class Solution03 {
    private Set<Integer> numberSet = new HashSet<>();
    private boolean[] visited;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];

        permutation(numbers, "", 0);

        int count = 0;
        for (int num : numberSet) {
            if (isPrime(num)) {
                count++;
            }
        }

        return count;
    }

    private void permutation(String numbers, String current, int depth) {
        if (!current.equals("")) {
            numberSet.add(Integer.parseInt(current));
        }

        if (depth == numbers.length()) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(numbers, current + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        if (num == 2) {
            return true;
        }

        if (num % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}