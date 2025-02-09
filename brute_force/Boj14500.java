package brute_force;

import java.util.*;
import java.io.*;

//백준 테트로미노 Boj14500
public class Boj14500 {
    static int N;
    static int M;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int res = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, 1, map[i][j]);
                checkT(i, j);
            }
        }

        System.out.print(res);
    }

    static void checkT(int x, int y) {
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (outOfRange(nx, ny)) continue;
            arr.add(map[nx][ny]);
        }

        if (arr.size() < 3) return;

        if (arr.size() == 4) {
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                sum = map[x][y];
                for (int j = 0; j < 4; j++) {
                    if (i == j) continue;
                    sum += arr.get(j);
                }
                res = Math.max(res, sum);
            }
        } else if (arr.size() == 3) {
            int sum = map[x][y];
            for (int i = 0; i < 3; i++) {
                sum += arr.get(i);
            }
            res = Math.max(res, sum);
        }
    }

    static void dfs(int x, int y, int depth, int sum) {
        visited[x][y] = true;

        if (depth == 4) {
            res = Math.max(res, sum);
            visited[x][y] = false;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (outOfRange(nx, ny)) continue;
            if (visited[nx][ny]) continue;

            dfs(nx, ny, depth + 1, sum + map[nx][ny]);
        }

        visited[x][y] = false;
    }

    static boolean outOfRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }
}