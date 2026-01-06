package baekjoon.implementation;

import java.io.*;

//백준 그룹 단어 체커 Boj1316
public class Boj1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (T-- > 0) {
            String line = br.readLine();
            char c = line.charAt(0);
            boolean[] vis = new boolean[26];
            vis[(int)c - 'a'] = true;
            int i;
            for (i = 1; i < line.length(); i++) {
                char prev = line.charAt(i - 1);
                char cur = line.charAt(i);
                if (prev == cur) continue;
                if (vis[cur - 'a']) break;
                vis[cur - 'a'] = true;
            }
            if (i == line.length()) cnt++;
        }
        System.out.println(cnt);
    }
}