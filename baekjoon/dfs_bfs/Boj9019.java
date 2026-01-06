package baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

//백준 DSLR Boj9019
public class Boj9019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            String[] cmds = new String[10001];
            boolean[] visited = new boolean[10001];
            q.offer(a);
            cmds[a] = "";
            visited[a] = true;
            while (!q.isEmpty()) {
                int cur = q.poll();

                if (cur == b) {
                    sb.append(cmds[cur]).append("\n");
                    break;
                }
                String op = cmds[cur];

                int temp = (cur * 2) % 10000;
                if (!visited[temp]) {
                    cmds[temp] = op + "D";
                    visited[temp] = true;
                    q.offer(temp);
                }


                temp = cur - 1;
                if (temp == -1) temp = 9999;
                if (!visited[temp]) {
                    cmds[temp] = op + "S";
                    visited[temp] = true;
                    q.offer(temp);
                }


                temp = cur % 1000;
                int t = cur / 1000;
                temp = temp * 10 + t;

                if (!visited[temp]) {
                    cmds[temp] = op + "L";
                    visited[temp] = true;
                    q.offer(temp);
                }


                temp = cur / 10;
                t = cur % 10;
                temp = t * 1000 + temp;

                if (!visited[temp]) {
                    cmds[temp] = op + "R";
                    visited[temp] = true;
                    q.offer(temp);
                }
            }
        }
        System.out.println(sb);
    }
}
