package baekjoon.sorting;

import java.util.*;
import java.io.*;

//백준 좌표 압축 Boj18870
public class Boj18870 {

    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] arr;
    static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        sorted = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        sorted = arr.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();

        int rank = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], rank);
                rank++;
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }


}
