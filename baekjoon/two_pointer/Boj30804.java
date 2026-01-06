package baekjoon.two_pointer;

import java.io.*;
import java.util.*;

//백준 과일 탕후루 Boj30804
public class Boj30804 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] count = new int[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int maxLength = 0;
        int left = 0;
        int unique = 0;

        for (int right = 0; right < n; right++) {

            if (count[arr[right]] == 0) {
                unique++;
            }
            count[arr[right]]++;

            while (unique > 2) {
                count[arr[left]]--;

                if (count[arr[left]] == 0) {
                    unique--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        System.out.println(maxLength);
    }

}
