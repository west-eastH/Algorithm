package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 숫자 정사각형 Boj1051
public class Boj1051 {

    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
        int start = Math.min(n, m);
        for (; start > 0; start--) {
            for (int i = 0; i <= n - start; i++) {
                for (int j = 0; j <= m - start; j++) {
                    if (board[i][j] == board[i + start - 1][j + start - 1] && board[i][j] == board[i + start - 1][j] && board[i][j] == board[i][j + start - 1]) {
                        System.out.println(start * start);
                        return;
                    }
                }
            }
        }
    }
}
