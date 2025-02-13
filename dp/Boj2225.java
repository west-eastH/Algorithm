package dp;

import java.io.*;
import java.util.*;

//백준 합분해 Boj2225
public class Boj2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] d = new int[k + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            d[1][i] = 1;
        }
        for (int i = 0; i <= k; i++) {
            d[i][0] = 1;
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                for (int l = 0; l <= j; l++) {
                    d[i][j] = (d[i][j] + d[i - 1][l]) % 1000000000;
                }
            }
        }

        System.out.print(d[k][n]);

    }
}