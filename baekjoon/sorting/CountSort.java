package baekjoon.sorting;

public class CountSort {

    public static final int MAX_VALUE = 9;
    public static void main(String[] args) {
        int n = 15;
        int[] arr = {7, 4, 2, 1, 9, 2, 5, 2, 4, 5, 7, 8, 5, 3, 6};

        int[] cnt = new int[MAX_VALUE + 1];

        for (int i = 0; i < n; i++) {
            cnt[arr[i]] += 1;
        }
        for (int i = 0; i < MAX_VALUE; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }

}
