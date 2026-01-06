package baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 Z Boj1074
public class Boj1074 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(dfs(N, r, c));
    }

    public static int dfs(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }

        int half = 1 << (n - 1);

        if (r < half && c < half) {
            return dfs(n - 1, r, c);
        } else if (r < half && c >= half) {
            return half * half + dfs(n - 1, r, c - half);
        } else if (r >= half && c < half) {
            return 2 * half * half + dfs(n - 1, r - half, c);
        } else {
            return 3 * half * half + dfs(n - 1, r - half, c - half);
        }
    }

}
