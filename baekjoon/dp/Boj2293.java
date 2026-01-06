package baekjoon.dp;

import java.io.*;
import java.util.*;

//백준 동전1 Boj2293
public class Boj2293 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        long[] d = new long[k + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        d[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                d[j] += d[j - arr[i]];
            }
        }
        System.out.println(d[k]);
    }
}