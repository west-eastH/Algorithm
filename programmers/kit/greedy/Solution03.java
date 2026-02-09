package programmers.kit.greedy;

import java.util.*;

class Solution03 {
    public int solution(int[] people, int limit) {

        int two = 0;
        int left = 0;
        int right = people.length - 1;

        Arrays.sort(people);

        while (left < right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
                two++;
            } else {
                right--;
            }
        }

        return people.length - two;
    }
}