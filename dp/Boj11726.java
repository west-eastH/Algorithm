package dp;

import java.io.*;

//백준 2×n 타일링 11726
public class Boj11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n + 2];
        d[1] = 1;
        d[2] = 2;
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 2] + d[i - 1]) % 10007;
        }
        System.out.println(d[n]);
    }
}