package dp;

import java.io.*;
import java.util.*;

//백준 가장 긴 증가하는 부분 수열 Boj11053
public class Boj11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        int[] d = new int[n + 1];
        Arrays.fill(d, 1);

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    d[i] = Math.max(d[j] + 1, d[i]);
                }
            }
        }

        int result = 0;
        for (int i : d) {
            result = Math.max(result, i);
        }
        System.out.println(result);
    }

}
