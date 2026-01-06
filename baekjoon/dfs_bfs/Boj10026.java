package baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

public class Boj10026 {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] map;
    static boolean[][] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        visited = new boolean[n][n];
        int normalCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, false);
                    normalCount++;
                }
            }
        }

        visited = new boolean[n][n];
        int colorBlindCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, true);
                    colorBlindCount++;
                }
            }
        }

        System.out.println(normalCount + " " + colorBlindCount);
    }

    public static void bfs(int x, int y, boolean isColorBlind) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        char color = map[x][y];

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                    continue;
                }

                if (!isColorBlind && map[nx][ny] == color) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
                else if (isColorBlind) {
                    if ((color == 'R' || color == 'G') && (map[nx][ny] == 'R' || map[nx][ny] == 'G')) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                    else if (color == 'B' && map[nx][ny] == 'B') {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}