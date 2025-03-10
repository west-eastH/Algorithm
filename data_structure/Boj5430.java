package data_structure;

import java.util.*;
import java.io.*;

//백준 AC Boj5430
public class Boj5430 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String p = br.readLine();
            int size = Integer.parseInt(br.readLine());
            Deque<Integer> dq = new LinkedList<>();
            String line = br.readLine();
            line = line.substring(1, line.length() - 1);
            String[] lineArr = line.split(",");
            if (lineArr.length > 0) {
                for (String s : lineArr) {
                    if (!s.equals(""))
                        dq.offerLast(Integer.parseInt(s));
                }
            }
            boolean reverse = false;
            boolean flag = false;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'R') {
                    reverse = !reverse;
                }
                else {
                    if (dq.isEmpty()) {
                        flag = true;
                        break;
                    } else {
                        if (reverse) {
                            dq.pollLast();
                        } else {
                            dq.pollFirst();
                        }
                    }
                }
            }
            if (flag) {
                sb.append("error\n");
            } else {
                sb.append(dequeToStr(dq, reverse)).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static String dequeToStr(Deque<Integer> dq, boolean reverse) {
        if (dq.isEmpty()) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        result.append("[");

        if (reverse) {
            int size = dq.size();
            for (int i = 0; i < size - 1; i++) {
                result.append(dq.pollLast()).append(",");
            }
            result.append(dq.pollLast());
        } else {
            int size = dq.size();
            for (int i = 0; i < size - 1; i++) {
                result.append(dq.pollFirst()).append(",");
            }
            result.append(dq.pollFirst());
        }

        result.append("]");
        return result.toString();
    }
}
