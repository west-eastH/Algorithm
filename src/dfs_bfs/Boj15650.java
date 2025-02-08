package dfs_bfs;

import java.io.*;
import java.util.*;

//백준 N과 M(2) 15650
public class Boj15650 {
    static int n,m;
    static int[] board;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[m];
        dfs(0, m, 1);
        System.out.print(sb);
    }

    public static void dfs(int depth, int m, int start) {
        if (depth == m) {
            for (int a : board) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            board[depth] = i;
            dfs(depth + 1, m, i + 1);
        }
    }
}