package baekjoon.data_structure;

import java.io.*;
import java.util.*;

//백준 이중 우선순위 큐 Boj7662
public class Boj7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Long> minQueue = new PriorityQueue<>();
            PriorityQueue<Long> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
            Map<Long, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                Long num = Long.parseLong(st.nextToken());

                if (cmd.equals("I")) {
                    minQueue.offer(num);
                    maxQueue.offer(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
                else {
                    if (num == -1) {
                        removeNum(minQueue, map);
                    } else {
                        removeNum(maxQueue, map);
                    }
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                while (!maxQueue.isEmpty() && map.getOrDefault(maxQueue.peek(), 0) == 0) {
                    maxQueue.poll();
                }
                while (!minQueue.isEmpty() && map.getOrDefault(minQueue.peek(), 0) == 0) {
                    minQueue.poll();
                }
                sb.append(maxQueue.peek()).append(" ").append(minQueue.peek()).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void removeNum(PriorityQueue<Long> queue, Map<Long, Integer> map) {

        while (!queue.isEmpty()) {
            Long num = queue.poll();
            int size = map.getOrDefault(num, 0);

            if (size > 0) {
                map.put(num, size - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
                break;
            }
        }
    }
}
