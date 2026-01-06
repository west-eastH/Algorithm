package baekjoon.string;

import java.io.*;

public class Boj5525 {

    static int n, m;
    static String line;
    static int result, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        line = br.readLine();

        result = 0;
        cnt = 0;
        for (int i = 1; i < m - 1; i++) {
            if (line.charAt(i - 1) == 'I' && line.charAt(i) == 'O' && line.charAt(i + 1) == 'I') {
                cnt++;
                if (n == cnt) {
                    cnt--;
                    result++;
                }
                i++;
            } else {
                cnt = 0;
            }
        }
        System.out.println(result);
    }
}