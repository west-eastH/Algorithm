package swea;

import java.util.*;
import java.io.*;

//파리 퇴치3 SWEA12712
public class Solution {

    static int[] plusDirX = {-1, 1, 0, 0};
    static int[] plusDirY = {0, 0, -1, 1};
    static int[] crossDirX = {-1, -1, 1, 1};
    static int[] crossDirY = {-1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] board = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int plusSum = calculateSum(board, i, j, N, M, plusDirX, plusDirY);
                    result = Math.max(result, plusSum);

                    int crossSum = calculateSum(board, i, j, N, M, crossDirX, crossDirY);
                    result = Math.max(result, crossSum);
                }
            }

            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }

    private static int calculateSum(int[][] board, int x, int y, int N, int M,
        int[] dirX, int[] dirY) {
        int sum = board[x][y];

        for (int k = 1; k < M; k++) {
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dirX[dir] * k;
                int ny = y + dirY[dir] * k;

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                sum += board[nx][ny];
            }
        }

        return sum;
    }
}