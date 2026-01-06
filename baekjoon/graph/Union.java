package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Union {

    public static int v, e;
    public static int[] parent = new int[100001];

    public static int findParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            unionParent(a, b);
        }

        System.out.println("각 원소가 속한 집합: ");
        for (int i = 1; i <= v; i++) {
            System.out.println(findParent(i) + " ");
        }
        System.out.println();

        System.out.println("부모 테이블: ");
        for (int i = 1; i <= v; i++) {
            System.out.println(parent[i] + " ");
        }
        System.out.println();
    }

}
