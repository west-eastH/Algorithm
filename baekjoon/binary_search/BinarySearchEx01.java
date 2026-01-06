package baekjoon.binary_search;

import java.io.*;
import java.util.*;

//나동빈 떡볶이 떡 만들기
public class BinarySearchEx01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = (int) 1e9;
        int result = 0;

        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2;

            for (int x : arr) {
                if (x > mid) {
                    total += x - mid;
                }
            }

            if (total >= m) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}