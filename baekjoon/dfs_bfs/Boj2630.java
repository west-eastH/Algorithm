package baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

//백준 색종이 만들기 Boj2630
public class Boj2630 {

    static int N;
    static int white = 0;
    static int blue = 0;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void dfs(int row, int col, int size) {

        if (check(row, col, size)) {
            if (board[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;

        dfs(row, col, newSize);
        dfs(row, col + newSize, newSize);
        dfs(row + newSize, col, newSize);
        dfs(row + newSize, col + newSize, newSize);
    }

    public static boolean check(int row, int col, int size) {

        int color = board[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
