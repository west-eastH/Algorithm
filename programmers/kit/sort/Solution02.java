package programmers.kit.sort;

import java.util.*;

class Solution02 {
    public int solution(int[] citations) {
        Integer[] arr = new Integer[citations.length];

        for (int i = 0; i < citations.length; i++) {
            arr[i] = citations[i];
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int h = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 <= arr[i]) {
                h = i + 1;
            } else {
                break;
            }
        }
        return h;
    }
}