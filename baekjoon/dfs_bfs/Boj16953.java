package baekjoon.dfs_bfs;

import java.util.*;
import java.io.*;

//백준 A -> B Boj16953
public class Boj16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        Map<Long, Integer> map = new HashMap<>();
        Queue<Long> q = new LinkedList<>();
        q.offer(a);
        map.put(a, 1);
        while (!q.isEmpty()) {
            long cur = q.poll();
            long temp = cur * 2;
            if (temp <= b) {
                q.offer(temp);
                map.put(temp, map.get(cur) + 1);
            }
            temp = cur * 10 + 1;
            if (temp <= b) {
                q.offer(temp);
                map.put(temp, map.get(cur) + 1);
            }
        }

        if (map.containsKey(b)) {
            System.out.println(map.get(b));
        } else {
            System.out.println(-1);
        }
    }
}