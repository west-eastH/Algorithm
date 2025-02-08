package dfs_bfs;
import java.io.*;
import java.util.*;

//나동빈 미로 탈출
public class DfsEx02 {

    static int n, m;
    static int[][] board = new int[201][201];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        dfs(0, 0);
        System.out.println(board[n - 1][m - 1]);
    }

    static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;

            if (board[nx][ny] != 1)
                continue;
            board[nx][ny] = board[x][y] + 1;
            dfs(nx, ny);
        }
    }
}
