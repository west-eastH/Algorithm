package binary_search;

import java.io.*;
import java.util.*;

//백준 숫자 카드 2 Boj10816
public class Boj10816 {
    static Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
    static final boolean LEFT = true;
    static final boolean RIGHT = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        int[] cards = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            map1.put(cards[i], 0);
        }

        for (int i = 0; i < m; i++) {
            int left = binarySearch(arr, 0, n - 1, cards[i], LEFT);
            int right = binarySearch(arr, 0, n - 1, cards[i], RIGHT);
            if (left != -1 && right != -1) {
                map1.put(cards[i], right - left + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            sb.append(map1.get(cards[i])).append(" ");
        }
        System.out.println(sb);
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