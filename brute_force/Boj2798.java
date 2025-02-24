package brute_force;

import java.io.*;
import java.util.*;

//백준 블랙잭 Boj2798
public class Boj2798 {

    static int max = Integer.MIN_VALUE;
    static int n;
    static int m;
    static int[] arr;
    static int[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        selected = new int[3];
        find(0, 0);

        System.out.println(max);
    }

    public static void find(int start, int depth) {
        if (depth == 3) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += selected[i];
            }
            if (sum <= m) {
                max = Math.max(max, sum);
            }
            return;
        }

        for (int i = start; i < n; i++) {
            selected[depth] = arr[i];
            find(i + 1, depth + 1);
        }
    }

}
