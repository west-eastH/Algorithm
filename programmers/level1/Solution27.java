package programmers.level1;

class Solution27 {
    public String solution(String X, String Y) {

        int[] arrA = new int[10];
        int[] arrB = new int[10];
        int[] count = new int[10];

        char[] x = X.toCharArray();
        char[] y = Y.toCharArray();

        for (int i = 0; i < x.length; i++) {
            arrA[(int)(x[i] - '0')]++;
        }

        for (int i = 0; i < y.length; i++) {
            arrB[(int)(y[i] - '0')]++;
        }
        for (int i = 0; i < 10; i++) {
            count[i] = Math.min(arrA[i], arrB[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) {
                    sb.append(i);
                }
            }
        }

        String answer = sb.toString();

        if (answer.length() == 0) {
            return "-1";
        }

        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer;
    }
}