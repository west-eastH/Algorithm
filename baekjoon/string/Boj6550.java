package baekjoon.string;

import java.io.*;
import java.util.*;

//백준 부분 문자열 6550
public class Boj6550 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;

        while ((str = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(str);
            String s = st.nextToken();
            String t = st.nextToken();

            int idx = 0;
            for (int i = 0; i < t.length(); i++) {
                if (s.charAt(idx) == t.charAt(i)) {
                    idx++;
                }

                if (idx == s.length()) {
                    break;
                }
            }

            if (idx == s.length()) {
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
        }
        System.out.print(sb);

    }
}