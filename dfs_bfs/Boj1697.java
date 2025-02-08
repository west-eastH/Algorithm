package dfs_bfs;

import java.io.*;
import java.util.*;

//백준 숨바꼭질 1697
public class Boj1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] board = new int[100001];
        boolean[] visited = new boolean[100001];

        Queue<Integer> q = new LinkedList<>();
        q.offer(a);
        board[a] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == b)
                break;

            if (cur - 1 >= 0 && !visited[cur - 1]) {
                board[cur - 1] = board[cur] + 1;
                visited[cur - 1] = true;
                q.offer(cur - 1);
            }
            if (cur + 1 <= 100000 && !visited[cur + 1]) {
                board[cur + 1] = board[cur] + 1;
                visited[cur + 1] = true;
                q.offer(cur + 1);
            }
            if (cur * 2 <= 100000 && !visited[cur * 2]) {
                board[cur * 2] = board[cur] + 1;
                visited[cur * 2] = true;
                q.offer(cur * 2);
            }
        }
        System.out.println(board[b]);
    }
}