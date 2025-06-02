package programmers.level2;

//프로그래머스 Level2 비밀 코드 해독
class Solution04 {
    static int[] selected = new int[5];
    static int[][] Q;
    static int[] ANS;
    static int N;
    static int result;
    public int solution(int n, int[][] q, int[] ans) {
        N = n;
        Q = q;
        ANS = ans;
        dfs(0, 1);
        return result;

    }

    public static void dfs(int depth, int num) {
        if (depth == 5) {
            check();
            return;
        }
        for (int i = num; i <= N; i++) {
            selected[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }

    public static void check() {
        for (int i = 0; i < Q.length; i++) {
            int cnt = 0;
            for (int j = 0; j < Q[i].length; j++) {
                for (int k = 0; k < 5; k++) {
                    if (Q[i][j] == selected[k]) cnt++;
                }
            }
            if (cnt != ANS[i]) return;
        }
        result++;
    }
}