package brute_force;

import java.util.*;
import java.io.*;

//백준 마인크래프트 Boj18111
public class Boj18111 {

    static StringBuilder sb = new StringBuilder();
    static int[][] board;
    static int time = Integer.MAX_VALUE;
    static int height = 0;
    static int n, m, b;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
        }

        for (int h = min; h <= max; h++) {
            int block = b;
            int t = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int diff = board[i][j] - h;
                    if (diff > 0) {
                        t = t + 2 * (diff);
                        block += diff;
                    } else if (diff < 0) {
                        t = t + Math.abs(diff);
                        block -= Math.abs(diff);
                    }
                }
            }
            if (block >= 0 && t <= time) {
                height = h;
                time = t;
            }
        }

        System.out.println(time + " " + height);
    }

}
