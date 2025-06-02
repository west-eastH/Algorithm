package programmers.level1;

//프로그래머스 Level1 이웃한 칸
class Solution08 {
    public int solution(String[][] board, int h, int w) {
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        String color = board[h][w];
        int size = board.length;
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];
            if (nx < 0 || ny < 0 || nx >= size || ny >= size)
                continue;
            if (board[nx][ny].equals(color))
                cnt++;

        }
        return cnt;
    }
}