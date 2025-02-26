package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 나무 자르기 Boj2805
public class Boj2805 {

    static int N;
    static int M;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N];
        long max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        long result = binarySearch(0, max, M);
        System.out.println(result);
    }

    public static long binarySearch(long start, long end, long target) {
        long mid = (start + end) / 2;
        long sum = 0;
        long result = -1;

        if (start <= end) {
            for (int i = 0; i < N; i++) {
                if (arr[i] - mid > 0) {
                    sum += (arr[i] - mid);
                }
            }
            if (sum >= target) {
                result = mid;
                result = Math.max(result, binarySearch(mid + 1, end, target));
            } else {
                result = binarySearch(start, mid - 1, target);
            }
        }
        return result;
    }
}
