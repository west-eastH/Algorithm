package baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

//백준 쉬운 최단거리 14940
public class Boj14940 {

    static int[][] board;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = 0;
                }
                if (board[i][j] == 0) {
                    visited[i][j] = 0;
                }
            }
        }
        bfs();
        print();

    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(visited[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void bfs() {

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (visited[nx][ny] != -1) {
                    continue;
                }
                if (board[nx][ny] == 0) {
                    continue;
                }
                visited[nx][ny] = visited[cx][cy] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }

    }
}