package baekjoon.dijkstra;

import baekjoon.greedy.Node;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DijkstraEx01 {

    public static final int INF = (int) 1e9;
    public static int n, m, start;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] d = new int[30001];

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();

            if (d[now] < dist) continue;

            ArrayList<Node> cur = graph.get(now);
            for (int i = 0; i < cur.size(); i++) {
                int cost = d[now] + cur.get(i).getDistance();

                if (cost < d[cur.get(i).getIndex()]) {
                    d[cur.get(i).getIndex()] = cost;
                    pq.offer(new Node(cur.get(i).getIndex(), cost));
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph.get(x).add(new Node(y, z));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        int count = 0;

        int maxDistance = 0;

        for (int i = 1; i <= n; i++) {
            if (d[i] != INF) {
                count += 1;
                maxDistance = Math.max(maxDistance, d[i]);
            }
        }

        System.out.println(count - 1 + " " + maxDistance);
    }
}
