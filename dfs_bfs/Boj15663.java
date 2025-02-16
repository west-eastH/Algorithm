package dfs_bfs;

import java.io.*;
import java.util.*;

//백준 N과 M (9) Boj15663
public class Boj15663 {
    static int N, M;
    static int[] arr;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        selected = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int depth) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int prev = -1;
        for(int i = 0; i < N; i++) {
            if(!visited[i] && prev != arr[i]) {
                visited[i] = true;
                selected[depth] = arr[i];
                prev = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}