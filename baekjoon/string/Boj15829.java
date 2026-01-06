package baekjoon.string;

import java.io.*;

/* 필요 개념
* (a × b) mod m
* ((a mod m) × (b mod m)) mod m
* (a × (b mod m)) mod m
* */

//백준 Hashing 15829
public class Boj15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();

        long result = 0;
        long pow = 1;
        long mod = 1234567891;

        for(int i = 0; i < n; i++) {
            result = (result + (line.charAt(i) - 'a' + 1) * pow) % mod;
            pow = (pow * 31) % mod;
        }

        System.out.println(result);
    }
}