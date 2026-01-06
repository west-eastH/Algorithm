package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//두 개의 숫자열 SWEA1959
public class SWEA1959 {

    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arrA = new int[N];
            int[] arrB = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            int result = 0;

            int cycle = Math.abs(N - M);

            for (int i = 0; i <= cycle; i++) {
                int sum = 0;
                if (N < M) {
                    for (int j = 0; j < N; j++) {
                        sum += arrA[j] * arrB[j + i];
                    }
                } else {
                    for (int j = 0; j < M; j++) {
                        sum += arrA[j + i] * arrB[j];
                    }
                }
                result = Math.max(result, sum);
            }

            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }

        System.out.print(sb);
    }
}