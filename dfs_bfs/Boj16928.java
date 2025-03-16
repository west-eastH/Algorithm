package dfs_bfs;

import java.io.*;
import java.util.*;

//백준 뱀과 사다리 게임 Boj16928
public class Boj16928 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[101];
        int[] distance = new int[101];

        for (int i = 1; i <= 100; i++) {
            arr[i] = i;
            distance[i] = -1;
        }

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a] = b;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        distance[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == 100) {
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                if (next <= 100) {
                    next = arr[next];

                    if (distance[next] == -1) {
                        q.offer(next);
                        distance[next] = distance[cur] + 1;
                    }
                }
            }
        }
        System.out.println(distance[100]);
    }
}