package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


//1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
//백준 숨바꼭질3 Boj13549
public class Boj13549 {

    static class Node implements Comparable<Node> {

        private int pos;
        private int time;

        public Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        visited = new boolean[100005];

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(n, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curPos = cur.pos;
            int curTime = cur.time;

            if (visited[curPos]) {
                continue;
            }

            visited[curPos] = true;

            if (curPos == k) {
                System.out.println(curTime);
                return;
            }

            int next = curPos - 1;
            if (next >= 0 && !visited[next]) {
                q.offer(new Node(next, curTime + 1));
            }

            next = curPos + 1;
            if (next < 100005 && !visited[next]) {
                q.offer(new Node(next, curTime + 1));
            }

            next = curPos * 2;
            if (next < 100005 && !visited[next]) {
                q.offer(new Node(next, curTime));
            }
        }
    }
}
