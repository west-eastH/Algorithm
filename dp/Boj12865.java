package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 평범한 배낭 Boj12865
public class Boj12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] d = new int[N + 1][K + 1];
        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            weights[i] = w;
            values[i] = v;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (weights[i] > j) {
                    d[i][j] = d[i - 1][j];
                } else {
                    d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - weights[i]] + values[i]);
                }
            }
        }

        System.out.println(d[N][K]);
    }

}
