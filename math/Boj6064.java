package math;

import java.io.*;
import java.util.*;

//백준 카잉달력 Boj6064
public class Boj6064 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int lcm = lcm(m, n);
            int result = -1;

            for (int j = x; j <= lcm; j += m) {
                int tempY = j % n == 0 ? n : j % n;

                if (tempY == y) {
                    result = j;
                    break;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

}
