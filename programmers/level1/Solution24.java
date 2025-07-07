package programmers.level1;

import java.util.ArrayList;
import java.util.List;

//프로그래머스 Level1 햄버거 만들기
class Solution24 {

    public int solution(int[] ingredient) {
        int answer = 0;

        List<Integer> arr = new ArrayList<>();
        for (int i : ingredient) {
            arr.add(i);
            int size = arr.size();

            while (size >= 4) {
                if (!(arr.get(size - 4) == 1 && arr.get(size - 3) == 2 && arr.get(size - 2) == 3
                    && arr.get(size - 1) == 1)) {
                    break;
                }
                for (int j = 0; j < 4; j++) {
                    arr.remove(arr.size() - 1);
                }
                answer++;
            }
        }
        return answer;
    }
}

