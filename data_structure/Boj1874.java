package data_structure;

import java.io.*;
import java.util.*;

//백준 스택 수열 1874
public class Boj1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        int cur = 0;
        for (int i = 1; i <= n; i++) {
            s.push(i);
            sb.append("+\n");
            while(!s.isEmpty() && s.peek() == arr[cur]) {
                s.pop();
                sb.append("-\n");
                cur++;
            }
        }
        if (s.isEmpty()) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
    }
}
