package baekjoon.dp;


import java.io.*;
import java.util.*;

//백준 정수 삼각형 1932
public class Boj1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[n + 1][n + 1];
        int[][] tree = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                tree[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        d[0][0] = tree[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    d[i][j] = d[i - 1][j] + tree[i][j];
                } else if (j == i) {
                    d[i][j] = d[i - 1][j - 1] + tree[i][j];
                } else {
                    d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + tree[i][j];
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(d[n - 1][i], result);
        }
        System.out.println(result);
    }
}