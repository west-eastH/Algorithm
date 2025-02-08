package implementation;

import java.io.*;
import java.util.*;

//백준 일곱난쟁이 Boj2309
public class Boj2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
        }
        StringBuilder sb = new StringBuilder();
        int temp = sum - 100;
        Arrays.sort(arr);
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (arr[i] + arr[j] == temp) {
                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j) continue;
                        sb.append(arr[k]).append("\n");
                    }
                    System.out.print(sb);
                    return;
                }
            }
        }
    }
}