package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//백준 치킨 배달 Boj15686
public class Boj15686 {

    static int N;
    static int M;
    static int[][] board;
    static ArrayList<int[]> chicken = new ArrayList<>();
    static boolean[] selected;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 2) {
                    chicken.add(new int[]{i, j});
                    board[i][j] = 0;
                } else {
                    board[i][j] = x;
                }
            }
        }
        selected = new boolean[chicken.size()];
        selectChicken(0, 0);

        System.out.println(result);
    }

    private static void selectChicken(int start, int cnt) {
        if (cnt == M) {
            calculate();
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            if (!selected[i]) {
                selected[i] = true;
                selectChicken(i + 1, cnt + 1);
                selected[i] = false;
            }
        }
    }

    public static void calculate() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    sum += findMin(i, j);
                }
            }
        }
        result = Math.min(sum, result);
    }

    private static int findMin(int i, int j) {
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < chicken.size(); k++) {
            if (selected[k]) {
                min = Math.min(Math.abs(i - chicken.get(k)[0]) + java.lang.Math.abs(j - chicken.get(k)[1]), min);
            }
        }
        return min;
    }

}
