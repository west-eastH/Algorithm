package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//백준 바이러스 Boj2606
public class Boj2606 {

    static int cnt = 0;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        isVisited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        find(1);
        System.out.println(cnt - 1);
    }

    public static void find(int n) {
        if (isVisited[n]) {
            return;
        }
        isVisited[n] = true;
        cnt++;
        for (int i = 0; i < arr.get(n).size(); i++) {
            find(arr.get(n).get(i));
        }
    }
}
