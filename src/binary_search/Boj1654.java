package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 랜선 자르기 1654
public class Boj1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];

        long max = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long start = 0;
        long end = max;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;

            for (int i = 0; i < k; i++) {
                if (arr[i] / mid > 0) cnt += arr[i] / mid;
            }
            if (cnt >= n) {
                result = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}