package baekjoon.math;

import java.io.*;
import java.util.*;

//백준 통계학 Boj2108
public class Boj2108 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        double sum = 0;
        int[] count = new int[8001];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
            count[num + 4000]++;
        }

        Arrays.sort(arr);

        ArrayList<Integer> maxArr = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < 8001; i++) {
            if (count[i] > max) {
                max = count[i];
                maxArr.clear();
                maxArr.add(i - 4000);
            } else if (count[i] == max) {
                maxArr.add(i - 4000);
            }
        }
        sb.append(Math.round(sum / n)).append("\n");
        sb.append(arr[n / 2]).append("\n");
        if (maxArr.size() == 1) {
            sb.append(maxArr.get(0)).append("\n");
        } else {
            sb.append(maxArr.get(1)).append("\n");
        }
        sb.append(arr[n - 1] - arr[0]);
        System.out.print(sb);
    }
}

