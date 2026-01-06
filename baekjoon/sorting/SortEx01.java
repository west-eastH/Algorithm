package baekjoon.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SortEx01 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arrA = new int[n];
        Integer[] arrB = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrB, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            if (arrA[i] < arrB[i])
                arrA[i] = arrB[i];
            else break;
        }
        int sum = 0;
        for (int i : arrA) {
            sum += i;
        }
        System.out.println(sum);
    }
}
