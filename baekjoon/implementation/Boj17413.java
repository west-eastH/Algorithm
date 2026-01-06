package baekjoon.implementation;

import java.io.*;

//백준 단어 뒤집기 2 Boj17413
public class Boj17413 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();

        for (int i = 0; i < line.length; i++) {
            if (line[i] == '<') {
                while(line[i] != '>') {
                    sb.append(line[i]);
                    i++;
                }
                sb.append(line[i]);
            } else if (line[i] == ' ') {
                sb.append(line[i]);
            } else {
                int j = 0;
                while (i + j < line.length && line[i + j] != ' ' && line[i + j] != '<') {
                    j++;
                }
                for (int k = i + j - 1; k >= i; k--) {
                    sb.append(line[k]);
                }
                i = i + j - 1;
            }
        }
        System.out.println(sb);
    }

}