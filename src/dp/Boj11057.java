package dp;

import java.io.*;

//백준 오르막 수 11057
public class Boj11057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[n + 1][10];
        for (int i = 0; i < 10; i++) {
            d[1][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            d[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 10; j++) {
                d[i][j] = (d[i - 1][j] + d[i][j - 1]) % 10007;
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += d[n][i];
        }
        System.out.println(result % 10007);
    }
}

