package programmers;

import java.io.*;
import java.util.*;

public class CyberCodingTest {
    static int n, m;
    static int[][] board;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = board[0][0];

        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j-1] + board[0][j];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + board[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + board[i][j];
            }
        }

        System.out.println(dp[n-1][m-1]);

        List<int[]> path = new ArrayList<>();
        int i = n - 1, j = m - 1;

        while (i > 0 || j > 0) {
            path.add(new int[]{i, j});
            if (i == 0) j--;
            else if (j == 0) i--;
            else if (dp[i-1][j] < dp[i][j-1]) i--;
            else j--;
        }
        path.add(new int[]{0, 0});
        Collections.reverse(path);

        for (int[] pos : path) {
            System.out.print("(" + pos[0] + "," + pos[1] + ") ");
        }
    }
}