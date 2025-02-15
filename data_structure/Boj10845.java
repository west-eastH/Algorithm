package data_structure;

import java.io.*;
import java.util.*;

//백준 큐 Boj10845
public class Boj10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Integer> q = new LinkedList<>();
        int last = 0;
        while (N-- > 0) {
            String str = br.readLine();
            if (str.equals("pop")) {
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(q.poll()).append("\n");
                }
            }
            else if (str.equals("size")) {
                sb.append(q.size()).append("\n");
            }
            else if (str.equals("empty")) {
                if (q.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
            else if (str.equals("front")) {
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(q.peek()).append("\n");
                }
            }
            else if (str.equals("back")) {
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(q.peekLast()).append("\n");
                }
            }
            else {
                String[] temp = str.split(" ");
                q.offer(Integer.parseInt(temp[1]));
            }
        }
        System.out.print(sb);

    }
}