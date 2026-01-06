package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 신나는 함수 실행 Boj9184
public class Boj9184 {

    static StringBuilder sb = new StringBuilder();
    static int[][][] d = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            int result = w(a, b, c);
            addBuffer(a, b, c, result);
        }
        System.out.println(sb);
    }

    public static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            if (d[20][20][20] != 0) {
                return d[20][20][20];
            }
            return w(20, 20, 20);
        }

        if (d[a][b][c] != 0) {
            return d[a][b][c];
        }

        if (a < b && b < c) {
            d[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            d[a][b][c] =
                w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        return d[a][b][c];
    }

    public static void addBuffer(int a, int b, int c, int result) {
        sb.append("w(")
            .append(a)
            .append(", ")
            .append(b)
            .append(", ")
            .append(c)
            .append(") = ")
            .append(result)
            .append("\n");
    }
}
