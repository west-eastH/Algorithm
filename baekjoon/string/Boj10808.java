package baekjoon.string;

import java.io.*;
import java.util.*;

//백준 알파벳 개수 10808
public class Boj10808 {

    static int[] arr = new int[30];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        String word = st.nextToken();

        for (int i = 0; i < word.length(); i++) {
            arr[(int) word.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 'a'; i <= 'z'; i++) {
            sb.append(arr[i - 'a']).append(' ');
        }

        System.out.println(sb.toString());
    }
}
