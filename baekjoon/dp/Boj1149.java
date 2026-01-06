package baekjoon.dp;

import java.io.*;
import java.util.*;

//백준 RGB거리 1149
public class Boj1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] rgb = new int[3][1001];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rgb[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] d = new int[3][1001];
        for (int i = 0; i < 3; i++) {
            d[i][0] = rgb[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                d[j][i] = Math.min(d[(j + 1) % 3][i - 1], d[(j + 2) % 3][i - 1]) + rgb[j][i];
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            result = Math.min(result, d[i][n - 1]);
        }
        System.out.println(result);
    }
}