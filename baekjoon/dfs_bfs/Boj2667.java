package baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

//백준 단지번호붙이기 2667
public class Boj2667 {

    static int[][] board;
    static boolean[][] vis;
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Integer> count = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        vis = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && !vis[i][j]) {
                    num++;
                    count.add(bfs(i, j));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(num).append("\n");
        Collections.sort(count);
        for (int cnt : count) {
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    public static int bfs(int cx, int cy) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{cx, cy});
        vis[cx][cy] = true;
        int result = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (vis[nx][ny] || board[nx][ny] == 0) {
                    continue;
                }

                q.offer(new int[]{nx, ny});
                vis[nx][ny] = true;
                result++;
            }
        }
        return result;
    }
}