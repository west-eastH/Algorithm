package string;

import java.io.*;
import java.util.*;

//백준 암호 해독 2149
public class Boj2149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String key = br.readLine();
        String crypto = br.readLine();

        char[] sortedKey = key.toCharArray();
        Arrays.sort(sortedKey);

        int col = key.length();
        int row = crypto.length() / col;
        boolean[] used = new boolean[col];

        String[] cryptoParts = new String[col];
        for (int i = 0; i < col; i++) {
            cryptoParts[i] = crypto.substring(row * i, row * (i + 1));
        }

        String[] plainParts = new String[col];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < col; j++) {
                if (!used[j] && key.charAt(j) == sortedKey[i]) {
                    plainParts[j] = cryptoParts[i];
                    used[j] = true;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sb.append(plainParts[j].charAt(i));
            }
        }
        System.out.print(sb);
    }
}