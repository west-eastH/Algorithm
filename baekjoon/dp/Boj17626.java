package baekjoon.dp;

import java.io.*;

//백준 Four Squares Boj17626
public class Boj17626 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] d = new int[n + 1];
        d[0] = 0;
        d[1] = 1;

        for (int i = 2; i <= n; i++) {
            d[i] = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                d[i] = Math.min(d[i], d[i - j * j] + 1);
            }
        }
        System.out.println(d[n]);
    }

}
