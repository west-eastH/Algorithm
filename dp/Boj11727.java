package dp;

import java.io.*;
import java.util.*;

//백준 2xn 타일링 2
public class Boj11727 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] d = new int[n + 2];
        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2] * 2) % 10007;
        }
        System.out.println(d[n]);
    }

}
