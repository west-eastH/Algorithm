package dp;

import java.io.*;
import java.util.*;

//백준 카드 구매하기 11052
public class Boj11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        int[] d = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            d[i] = arr[i];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                d[i] = Math.max(d[i], d[i - j] + arr[j]);
            }
        }
        System.out.println(d[n]);
    }
}
