package baekjoon.implementation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 연구소 Boj14502
public class Boj14502 {

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static ArrayList<Integer> virus_x = new ArrayList<>();
    public static ArrayList<Integer> virus_y = new ArrayList<>();
    static int N, M;
    static int[][] origin_board;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        origin_board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                origin_board[i][j] = Integer.parseInt(st.nextToken());
                if (origin_board[i][j] == 2) {
                    virus_x.add(i);
                    virus_y.add(j);
                }
            }
        }
        selectWall(0);

        System.out.println(max);

    }

    public static void selectWall(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (origin_board[i][j] == 0) {
                    origin_board[i][j] = 1;
                    selectWall(cnt + 1);
                    origin_board[i][j] = 0;
                }
            }
        }

    }

    private static void bfs() {

        int[][] simulationBoard = createCopyBoard(origin_board);

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < virus_x.size(); i++) {
            q.offer(new int[]{virus_x.get(i), virus_y.get(i)});
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (simulationBoard[nx][ny] >= 1) {
                    continue;
                }
                simulationBoard[nx][ny] = 2;
                q.offer(new int[]{nx, ny});
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (simulationBoard[i][j] == 0) {
                    cnt++;
                }
            }
        }
        if (cnt > max) {
            max = cnt;
        }
    }

    private static int[][] createCopyBoard(int[][] originBoard) {
        int[][] copyBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyBoard[i] = originBoard[i].clone();
        }
        return copyBoard;
    }
}
