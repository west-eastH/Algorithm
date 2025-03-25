package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 내려가기 Boj2096
public class Boj2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][3];
        int[][] d1 = new int[n + 1][3];
        int[][] d2 = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 3; i++) {
            d1[1][i] = arr[1][i];
            d2[1][i] = arr[1][i];
        }


        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    d1[i][j] = Math.max(d1[i - 1][j], d1[i - 1][j + 1]) + arr[i][j];
                    d2[i][j] = Math.min(d2[i - 1][j], d2[i - 1][j + 1]) + arr[i][j];
                } else if (j == 1) {
                    d1[i][j] = Math.max(d1[i - 1][j], Math.max(d1[i - 1][j - 1], d1[i - 1][j + 1])) + arr[i][j];
                    d2[i][j] = Math.min(d2[i - 1][j], Math.min(d2[i - 1][j - 1], d2[i - 1][j + 1])) + arr[i][j];
                } else {
                    d1[i][j] = Math.max(d1[i - 1][j], d1[i - 1][j - 1]) + arr[i][j];
                    d2[i][j] = Math.min(d2[i - 1][j], d2[i - 1][j - 1]) + arr[i][j];
                }
            }
        }
        int max = Math.max(d1[n][0], Math.max(d1[n][1], d1[n][2]));
        int min = Math.min(d2[n][0], Math.min(d2[n][1], d2[n][2]));

        System.out.println(max + " " + min);
    }

}
