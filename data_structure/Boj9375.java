package data_structure;

import java.io.*;
import java.util.*;

//백준 패션왕 신해빈 Boj9375
public class Boj9375 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String temp = st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int result = 1;
            for (Integer value : map.values()) {
                result *= (value + 1);
            }
            result -= 1;
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
