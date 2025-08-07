package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 스도쿠 Boj2580
public class Boj2580 {
    static int[][] board = new int[9][9];
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int row, int col) {
        if (found) return;

        if (row == 9) {
            found = true;
            return;
        }

        int nextRow = col == 8 ? row + 1 : row;
        int nextCol = col == 8 ? 0 : col + 1;

        if (board[row][col] != 0) {
            dfs(nextRow, nextCol);
            return;
        }

        for (int k = 1; k <= 9; k++) {
            if (check(row, col, k)) {
                board[row][col] = k;
                dfs(nextRow, nextCol);

                if (found) return;

                board[row][col] = 0;
            }
        }
    }

    public static boolean check(int row, int col, int k) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == k) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == k) {
                return false;
            }
        }

        int startX = row / 3 * 3;
        int startY = col / 3 * 3;

        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (board[i][j] == k) {
                    return false;
                }
            }
        }
        return true;
    }
}