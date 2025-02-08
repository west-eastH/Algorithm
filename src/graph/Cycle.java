package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cycle {

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

        boolean cycle = false;

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (findParent(a) == findParent(b)) {
                cycle = true;
                break;
            }
            else {
                unionParent(a, b);
            }
        }

        if (cycle) {
            System.out.println("사이클이 발생했습니다");
        }
        else {
            System.out.println("사이클이 발생하지 않았습니다.");
        }

    }

}
