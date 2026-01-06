package baekjoon.two_pointer;

import java.io.*;
import java.util.*;

//백준 두 수의 합 Boj3273
public class Boj3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int cnt = 0;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (arr[left] + arr[right] == x) {
                left++;
                right--;
                cnt++;
            } else if (arr[left] + arr[right] > x) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(cnt);
    }

}
