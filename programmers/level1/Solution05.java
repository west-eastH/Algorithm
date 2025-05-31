package programmers.level1;

//프로그래머스 Level1 공원
class Solution05 {
    public int solution(int[] mats, String[][] park) {
        int maxSize = -1;

        for (int size : mats) {
            if (canPlace(size, park)) {
                maxSize = Math.max(maxSize, size);
            }
        }

        return maxSize;
    }

    private boolean canPlace(int size, String[][] park) {
        int rows = park.length;
        int cols = park[0].length;

        for (int i = 0; i <= rows - size; i++) {
            for (int j = 0; j <= cols - size; j++) {
                if (isEmptyArea(i, j, size, park)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isEmptyArea(int startRow, int startCol, int size, String[][] park) {
        for (int i = startRow; i < startRow + size; i++) {
            for (int j = startCol; j < startCol + size; j++) {
                if (!"-1".equals(park[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}