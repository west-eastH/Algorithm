package brute_force;

import java.io.*;
import java.util.*;

//백준 체스판 다시 칠하기 Boj1018
public class Boj1018 {
    static char[][] board;
    static int min = 64;
    static final Boolean BLACK = true;
    static final Boolean WHITE = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int w = m - 8;
        int h = n - 8;

        for (int i = 0; i <= h; i++) {
            for (int j = 0; j <= w; j++) {
                check(i,j, BLACK);
                check(i,j, WHITE);
            }
        }
        System.out.println(min);
    }

    public static void check(int x, int y, Boolean isBlack) {
        char a,b;
        int sum = 0;
        if (isBlack) {
            a = 'B';
            b = 'W';
        } else {
            a = 'W';
            b = 'B';
        }
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if ((i + j) % 2 == 0 && board[i][j] == a) {
                    sum++;
                } else if ((i + j) % 2 == 1 && board[i][j] == b){
                    sum++;
                }
            }
        }
        min = Math.min(min, sum);
    }
}