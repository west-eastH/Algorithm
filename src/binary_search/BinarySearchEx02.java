package binary_search;

import java.io.*;
import java.util.*;

//나동빈 정렬된 배열에서 특정 수의 개수 구하기
public class BinarySearchEx02 {

    static final boolean LEFT = true;
    static final boolean RIGHT = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = binarySearch(arr, 0, n - 1, m, LEFT);
        int right = binarySearch(arr, 0, n - 1, m, RIGHT);

        if (left == -1 || right == -1) {
            System.out.println(-1);
        }
        else {
            System.out.println(right - left + 1);
        }
    }

    public static int binarySearch(int[] arr, int start, int end, int target, boolean flag) {
        int index = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                index = mid;
                if (flag == LEFT) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else if (arr[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return index;
    }
}
