package implementation;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[41][2];
        d[0][0] = 1;
        d[0][1] = 0;
        d[1][0] = 0;
        d[1][1] = 1;
        for (int i = 2; i <= 40; i++) {
            d[i][0] = d[i - 1][0] + d[i - 2][0];
            d[i][1] = d[i - 1][1] + d[i - 2][1];
        }
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append(d[num][0]).append(" ").append(d[num][1]).append("\n");
        }
        System.out.print(sb);
    }
}
