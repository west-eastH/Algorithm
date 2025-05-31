package programmers.level1;

//프로그래머스 Level1 택배 상자 꺼내기
class Solution01 {
    public int solution(int n, int w, int num) {
        int row = (num - 1) / w;
        int col;
        if (row % 2 == 0) {
            col = (num - 1) % w;
        } else {
            col = w - 1 - (num - 1) % w;
        }

        int result = 1;
        int lastRow = (n + w - 1) / w - 1;
        for (int nextRow = row + 1; nextRow <= lastRow; nextRow++) {
            if (nextRow < lastRow) {
                result++;
            } else {
                if (nextRow % 2 == 0) {
                    if ((n - 1) % w >= col) {
                        result++;
                    }
                } else {
                    if (w - 1 - (n - 1) % w <= col) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}