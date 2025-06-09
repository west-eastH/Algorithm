package programmers.level1;

//프로그래머스 Level1 공원 산책
class Solution12 {
    static char[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] answer = new int[2];
    static int H;
    static int W;

    public int[] solution(String[] park, String[] routes) {

        H = park.length;
        W = park[0].length();
        board = new char[H][W];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                board[i][j] = park[i].charAt(j);
                if (board[i][j] == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                    board[i][j] = 'O';
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            int flag = moveCheck(routes[i].charAt(0), routes[i].charAt(2) - '0');
            if (flag == 0) {
                // 북
                answer[0] -= routes[i].charAt(2) - '0';
            } else if (flag == 1) {
                // 서
                answer[1] -= routes[i].charAt(2) - '0';
            } else if (flag == 2) {
                // 남
                answer[0] += routes[i].charAt(2) - '0';
            } else if (flag == 3) {
                // 동
                answer[1] += routes[i].charAt(2) - '0';
            }
        }
        return answer;
    }

    public static int moveCheck(char dir, int dis) {
        int flag = 0;
        switch(dir) {
            case 'N': flag = 0;
                break;
            case 'W': flag = 1;
                break;
            case 'S': flag = 2;
                break;
            case 'E': flag = 3;
                break;
        }
        int x = answer[0];
        int y = answer[1];
        for (int i = 0; i < dis; i++) {
            x = x + dx[flag];
            y = y + dy[flag];

            if (x < 0 || y < 0 || x >= H || y >= W) {
                return -1;
            }
            if (board[x][y] == 'X') {
                return -1;
            }
        }
        return flag;
    }

}