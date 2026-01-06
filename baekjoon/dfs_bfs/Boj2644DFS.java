package baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

//백준 촌수계산
public class Boj2644DFS {

    static int n, a, b, m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int[] isVis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        isVis = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
            isVis[i] = -1;
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        isVis[a] = 0;
        dfs(a, 1);
        System.out.println(isVis[b]);
    }

    public static void dfs(int a, int depth) {
        for (int i : graph.get(a)) {
            if (isVis[i] == -1) {
                isVis[i] = depth;
                dfs(i, depth + 1);
            }
        }
    }
}