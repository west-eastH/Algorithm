package dp;

import java.io.*;

//백준 쉬운 계단 수 Bij10844
public class Boj10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] d = new long[10][101];
        int n = Integer.parseInt(br.readLine());
        d[0][1] = 0;
        for (int i = 1; i < 10; i++) {
            d[i][1] = 1;
        }

        for (int j = 2; j <= n; j++) {
            for (int i = 0; i < 10; i++) {
                if (i == 0) {
                    d[i][j] = d[1][j - 1] % 1000000000;
                }
                else if (i == 9) {
                    d[i][j] = d[8][j - 1] % 1000000000;
                }
                else {
                    d[i][j] = (d[i - 1][j - 1] + d[i + 1][j - 1]) % 1000000000;
                }
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + d[i][n]) % 1000000000;
        }
        System.out.println(result);
    }
}