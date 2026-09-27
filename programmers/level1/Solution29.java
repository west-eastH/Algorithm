package programmers.level1;

public class Solution29 {
    public int solution(int[][] signals) {
        int limit = 1;
        int len = signals.length;

        for (int i = 0; i < len; i++) {
            int cycle = signals[i][0] + signals[i][1] + signals[i][2];
            limit = lcm(limit, cycle);
        }

        for (int t = 1; t <= limit; t++) {
            boolean isAll = true;

            for (int i = 0; i < len; i++) {
                int g = signals[i][0];
                int y = signals[i][1];
                int r = signals[i][2];

                int cycle = g + y + r;
                int pos = (t - 1) % cycle + 1;

                if (!(g < pos && pos <= g + y)) {
                    isAll = false;
                    break;
                }
            }

            if (isAll) {
                return t;
            }
        }

        return -1;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
