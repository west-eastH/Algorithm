package baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 토마토 Boj7569
public class Boj7569 {

    static int[][][] board;
    static int[][][] count;
    static boolean[][][] visited;
    static int result = 0;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        board = new int[h][n][m];
        count = new int[h][n][m];
        visited = new boolean[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (board[i][j][k] == 1) {
                        q.offer(new int[]{i, j, k});
                        visited[i][j][k] = true;
                    }
                    if (board[i][j][k] == 0) {
                        count[i][j][k] = -1;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[1];
            int y = cur[2];
            int z = cur[0];

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) {
                    continue;
                }
                if (visited[nz][nx][ny] == true || board[nz][nx][ny] != 0) {
                    continue;
                }

                count[nz][nx][ny] = count[z][x][y] + 1;
                visited[nz][nx][ny] = true;
                q.offer(new int[]{nz, nx, ny});
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (count[i][j][k] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result, count[i][j][k]);
                }
            }
        }
        System.out.println(result);
    }
}
