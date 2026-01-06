package baekjoon.brute_force;

import java.io.*;
import java.util.*;

//백준 퇴사 Boj14501
public class Boj14501 {
    static int n;
    static int[] t, p;
    static int maxProfit = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        t = new int[n];
        p = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        findMaxProfit(0, 0);
        System.out.println(maxProfit);
    }

    static void findMaxProfit(int day, int profit) {
        if (day >= n) {
            maxProfit = Math.max(maxProfit, profit);
            return;
        }

        if (day + t[day] <= n) {
            findMaxProfit(day + t[day], profit + p[day]);
        }

        findMaxProfit(day + 1, profit);
    }
}