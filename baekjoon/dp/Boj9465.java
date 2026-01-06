package baekjoon.dp;

import java.util.*;
import java.io.*;

//백준 스티커 Boj9465
public class Boj9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n + 2];
            int[][] scoreBoard = new int[2][n + 2];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            scoreBoard[0][1] = arr[0][1];
            scoreBoard[1][1] = arr[1][1];
            scoreBoard[0][2] = arr[1][1] + arr[0][2];
            scoreBoard[1][2] = arr[0][1] + arr[1][2];

            for (int i = 3; i <= n; i++) {
                scoreBoard[0][i] = Math.max(scoreBoard[1][i - 2], scoreBoard[1][i - 1]) + arr[0][i];
                scoreBoard[1][i] = Math.max(scoreBoard[0][i - 2], scoreBoard[0][i - 1]) + arr[1][i];
            }
            int score = 0;
            for (int i = 0; i <= n; i++) {
                score = Math.max(score, Math.max(scoreBoard[0][i], scoreBoard[1][i]));
            }
            sb.append(score).append("\n");
        }
        System.out.println(sb);
    }

}
