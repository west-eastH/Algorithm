package swea;

import java.util.*;
import java.io.*;

//숫자 배열 회전 SWEA1961
class SWEA1961
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append("#").append(test_case).append("\n");
            int N = Integer.parseInt(br.readLine());

            int[][] board = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(board[N - j - 1][i]);
                }
                sb.append(" ");

                for (int j = 0; j < N; j++) {
                    sb.append(board[N - i - 1][N - j - 1]);
                }
                sb.append(" ");

                for (int j = 0; j < N; j++) {
                    sb.append(board[j][N - i - 1]);
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}