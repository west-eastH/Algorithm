package programmers.level1;

//프로그래머스 Level1 가장 많이 받은 선물
class Solution06 {
    public int solution(String[] friends, String[] gifts) {
        int len = friends.length;

        int[][] arr = new int[len][len];

        for (int i = 0; i < len; i++) {
            String name = friends[i];
            for (String str : gifts) {
                String[] temp = str.split(" ");
                if (temp[0].equals(name)) {
                    int friendIdx = findIdx(temp[1], friends);
                    arr[i][friendIdx]++;
                    arr[friendIdx][i]--;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                sum += arr[i][j];
            }
            arr[i][i] = sum;
        }
        int result = 0;
        for (int i = 0; i < len; i++) {
            int cnt = 0;
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                if (arr[i][j] > 0) {
                    cnt++;
                } else if (arr[i][j] == 0) {
                    if (arr[i][i] > arr[j][j]) {
                        cnt++;
                    }
                }
            }
            result = Math.max(result, cnt);
        }
        return result;
    }

    public int findIdx(String name, String[] friends) {
        for (int i = 0; i < friends.length; i++) {
            if (friends[i].equals(name))
                return i;
        }
        return -1;
    }
}

