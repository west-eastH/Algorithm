package baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

//백준 유기농 배추 Boj1012
public class Boj1012 {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int cnt = 0;

            int[][] board = new int[n][m];
            boolean[][] vis = new boolean[n][m];
            while(k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 1 && !vis[i][j]) {
                        bfs(i, j, board, vis);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    static void bfs(int x, int y, int[][] board, boolean[][] vis) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        vis[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (board[nx][ny] != 1 || vis[nx][ny]) continue;

                vis[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}