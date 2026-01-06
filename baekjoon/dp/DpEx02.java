package baekjoon.dp;

import java.io.*;
import java.util.*;

//나동빈 효율적인 화폐 구성
public class DpEx02 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[m + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                if (dp[j - arr[i]] != 10001) {
                    dp[j] = Math.min(dp[j - arr[i]] + 1, dp[j]);
                }
            }
        }
        if (dp[m] == 10001) {
            System.out.println(-1);
        }
        else
            System.out.println(dp[m]);
    }
}
