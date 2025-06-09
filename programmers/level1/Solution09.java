package programmers.level1;

import java.util.*;


//프로그래머스 Level1 데이터 분석
class Solution09 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        int extIdx = getIdx(ext);
        int sortIdx = getIdx(sort_by);

        return Arrays.stream(data)
            .filter(row -> row[extIdx] < val_ext)
            .sorted((o1, o2) -> Integer.compare(o1[sortIdx], o2[sortIdx]))
            .toArray(int[][]::new);
    }

    public static int getIdx(String str) {
        if (str.equals("code")) {
            return 0;
        } else if (str.equals("date")) {
            return 1;
        } else if (str.equals("maximum")) {
            return 2;
        } else {
            return 3;
        }
    }
}
