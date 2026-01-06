package baekjoon.string;

import java.io.*;

//백준 OX퀴즈 Boj8958
public class Boj8958{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int result = 0;
            int count = 1;

            String line = br.readLine();
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == 'O') {
                    result += count;
                    count++;
                }
                else {
                    count = 1;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}