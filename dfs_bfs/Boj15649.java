package dfs_bfs;

import java.io.*;
import java.util.*;

//백준 N과 M(1) 15649
public class Boj15649 {
    static int[] board;
    static boolean[] visited;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[m + 1];
        visited = new boolean[n + 1];

        dfs(0, m);
        System.out.print(sb);
    }

    public static void dfs(int depth, int m) {
        if (depth == m) {
            for(int i = 1; i <= m; i++) {
                sb.append(board[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                board[depth + 1] = i;
                visited[i] = true;
                dfs(depth + 1, m);
                visited[i] = false;
            }

        }
    }
}