package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//나동빈 음료수 얼려 먹기 BFS
public class BfsEx01 {

    static int n, m;
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (bfs(i, j)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    private static boolean bfs(int x, int y) {

        if (board[x][y] == 1) return false;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        board[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();


            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return true;
    }
}
