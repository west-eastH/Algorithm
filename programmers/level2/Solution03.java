package programmers.level2;

import java.util.*;

//프로그래머스 Level2 지게차와 크레인
class Solution03 {
    static char[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n;
    static int m;

    public int solution(String[] storage, String[] requests) {

        n = storage.length;
        m = storage[0].length();
        board = new char[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = storage[i].charAt(j);
            }
        }

        for (int i = 0; i < requests.length; i++) {
            if (requests[i].length() == 1) {
                myPop(false, requests[i].charAt(0));
            } else {
                myPop(true, requests[i].charAt(0));
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != '0')
                    cnt++;
            }
        }
        return cnt;
    }

    public static void myPop(boolean flag, char c) {
        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == c) {
                        board[i][j] = '0';
                    }
                }
            }

            return;
        }
        ArrayList<int[]> arr = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean[][] visited = new boolean[n + 1][m + 1];
                if (board[i][j] == c && !visited[i][j]) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    boolean end = false;
                    while (!q.isEmpty() && !end) {
                        int[] cur = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = cur[0] + dx[k];
                            int y = cur[1] + dy[k];
                            if (x < 0 || x >= n || y < 0 || y >= m) {
                                arr.add(new int[]{i, j});
                                end = true;
                                break;
                            }
                            if (board[x][y] == '0' && !visited[x][y]) {
                                visited[x][y] = true;
                                q.add(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            int x = arr.get(i)[0];
            int y = arr.get(i)[1];
            board[x][y] = '0';
        }
    }
}