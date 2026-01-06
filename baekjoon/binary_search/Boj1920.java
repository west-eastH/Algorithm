package baekjoon.binary_search;

import java.io.*;
import java.util.*;

//백준 수 찾기 Boj1920
public class Boj1920 {

    static int n,m;
    static long[] origin;
    static long[] find;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        origin = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            origin[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(origin);

        m = Integer.parseInt(br.readLine());
        find = new long[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            find[i] = Long.parseLong(st.nextToken());
        }

        for (Long l : find) {
            sb.append(binarySearch(l, 0, origin.length - 1, origin)).append("\n");
        }

        System.out.print(sb);
    }
    static int binarySearch(long target, int start, int end, long[] arr) {

        int mid = (start + end) / 2;

        if (start <= end) {
            if (arr[mid] == target) return 1;
            else if (arr[mid] > target) return binarySearch(target, start, mid - 1, arr);
            else return binarySearch(target, mid + 1, end, arr);
        }

        return 0;
    }
}
