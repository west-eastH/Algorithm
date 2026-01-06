package baekjoon.dp;

import java.util.*;
import java.io.*;

//나동빈 금광
public class DpEx03 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int board[][] = new int[n][m];
            int dp[][] = new int[n][m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = board[i][j];
                }
            }

            for (int j = 1; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    int leftUp, left, leftDown;

                    if (i == 0) leftUp = 0;
                    else leftUp = dp[i - 1][j - 1];

                    if(i == n - 1) leftDown = 0;
                    else leftDown = dp[i + 1][j - 1];

                    left = dp[i][j - 1];

                    dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(left, leftDown));
                }
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(dp[i][m - 1], max);
            }
            System.out.println(max);
        }
    }
}
