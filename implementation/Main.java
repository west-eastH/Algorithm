package implementation;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
//                    System.out.println("i = " + i + " j = " + j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            bfs(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j : visited[i]) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);
        visited[num][num] = 1;

        System.out.println(num);
        for (int i : graph.get(num)) {
            System.out.println(i);
        }
        System.out.println("============");
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : graph.get(cur)) {
                if (visited[num][i] == 0) {
//                    System.out.println("num = " + num + "i = " + i);
                    visited[num][i] = 1;
                    q.offer(i);
                }
            }
        }
    }
}
