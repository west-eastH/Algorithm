package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 로봇 청소기 Boj14503
public class Boj14503 {

    public static int NORTH = 0;
    public static int EAST = 1;
    public static int SOUTH = 2;
    public static int WEST = 3;

    static int N, M, r, c, d;
    static int[][] board;
    static int count = 0;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (flag) {
                break;
            }

            if (board[r][c] == 0) {
                board[r][c] = 2;
                count++;
            }

            if (check(r, c)) {
                turn();
                moveFront();
            } else {
                moveBack();
            }
        }
        System.out.println(count);
    }

    private static void moveFront() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int nr = r + dx[d];
        int nc = c + dy[d];

        if (nr >= 0 && nr < N && nc >= 0 && nc < M && board[nr][nc] == 0) {
            r = nr;
            c = nc;
        }
    }

    private static void turn() {
        d = (d + 3) % 4;
    }

    public static boolean check(int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 0) {
                return true;
            }
        }
        return false;
    }

    public static void moveBack() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int backDir = (d + 2) % 4;
        int nr = r + dx[backDir];
        int nc = c + dy[backDir];

        if (nr >= 0 && nr < N && nc >= 0 && nc < M && board[nr][nc] != 1) {
            r = nr;
            c = nc;
        } else {
            flag = true;
        }
    }
}