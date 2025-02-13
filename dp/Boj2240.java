package dp;

import java.io.*;
import java.util.*;

//백준 자두나무 Boj2240
public class Boj2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] plums = new int[T + 1];
        int[][][] d = new int[T + 1][W + 1][2];

        for (int i = 1; i <= T; i++) {
            plums[i] = Integer.parseInt(br.readLine()) - 1;
        }

        for (int i = 1; i <= T; i++) {
            d[i][0][0] = d[i - 1][0][0] + (plums[i] == 0 ? 1 : 0);

            for (int j = 1; j <= W; j++) {
                d[i][j][0] = Math.max(d[i - 1][j][0], d[i - 1][j - 1][1]) + (plums[i] == 0 ? 1 : 0);
                d[i][j][1] = Math.max(d[i - 1][j][1], d[i - 1][j - 1][0]) + (plums[i] == 1 ? 1 : 0);
            }
        }

        int result = 0;
        for (int i = 0; i <= W; i++) {
            result = Math.max(result, Math.max(d[T][i][0], d[T][i][1]));
        }

        System.out.println(result);
    }
}