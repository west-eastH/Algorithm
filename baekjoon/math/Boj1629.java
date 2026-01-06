package baekjoon.math;

import java.io.*;
import java.util.*;

//백준 곱셈 Boj1629
public class Boj1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    static long pow(long A, long B, long C) {
        if(B == 0) return 1;
        if(B == 1) return A % C;

        long temp = pow(A, B/2, C);

        if(B % 2 == 0) {
            return (temp * temp) % C;
        } else {
            return (((temp * temp) % C) * A) % C;
        }
    }
}