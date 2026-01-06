package baekjoon.graph;

import java.util.*;
import java.io.*;

//백준 DFS와 BFS 1260
public class Boj1260 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] dfsVis;
    static boolean[] bfsVis;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        dfsVis = new boolean[n + 1];
        bfsVis = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }
        dfs(v);
        sb.append("\n");
        bfs(v);
        System.out.print(sb);
    }

    public static void dfs(int start) {
        if (dfsVis[start]) {
            return;
        }

        dfsVis[start] = true;
        sb.append(start).append(" ");

        for (int i = 0; i < graph.get(start).size(); i++) {
            dfs(graph.get(start).get(i));
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        bfsVis[start] = true;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            sb.append(n).append(" ");

            for (int i = 0; i < graph.get(n).size(); i++) {
                if (bfsVis[graph.get(n).get(i)]) {
                    continue;
                }
                bfsVis[graph.get(n).get(i)] = true;
                queue.offer(graph.get(n).get(i));
            }
        }
    }
}