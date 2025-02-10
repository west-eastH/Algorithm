package brute_force;

import java.io.*;
import java.util.*;

//백준 연구소3 Boj17142
public class Boj17142 {

    static int n, m;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int result = Integer.MAX_VALUE;
    static ArrayList<int[]> viruses = new ArrayList<>();
    static int emptySpace = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                } else if (board[i][j] == 0) {
                    emptySpace++;
                }
            }
        }

        if (emptySpace == 0) {
            System.out.println(0);
            return;
        }

        combination(new int[m], 0, 0);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

    }

    static void combination(int[] selected, int start, int depth) {
        if (depth == m) {
            simulate(selected);
            return;
        }

        for (int i = start; i < viruses.size(); i++) {
            selected[depth] = i;
            combination(selected, i + 1, depth + 1);
        }
    }

    static void simulate(int[] selected) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        for (int idx : selected) {
            int[] virus = viruses.get(idx);
            q.offer(new int[]{virus[0], virus[1]});
            dist[virus[0]][virus[1]] = 0;
        }

        int infected = 0;
        int time = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (dist[nx][ny] != -1 || board[nx][ny] == 1) {
                    continue;
                }

                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;

                if (board[nx][ny] == 0) {
                    infected++;
                    time = dist[nx][ny];
                }

                q.offer(new int[]{nx, ny});
            }
        }

        if (infected == emptySpace) {
            result = Math.min(result, time);
        }
    }
}