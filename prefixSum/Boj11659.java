package prefixSum;

import java.io.*;
import java.util.*;

//백준 구간 합 구하기 4 Boj11659
public class Boj11659 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] numbers = new int[n];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum = sum + num;
            arr[i] = sum;
            numbers[i] = num;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(arr[b - 1] - arr[a - 1]  + numbers[a - 1]).append("\n");
        }

        System.out.print(sb);
    }
}
