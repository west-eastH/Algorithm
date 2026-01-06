package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 팰린드롬 만들기 Boj1213
public class Boj1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        int[] arr = new int[26];
        for (int i = 0; i < line.length; i++) {
            arr[line[i] - 'A']++;
        }
        int oddCount = 0;
        char oddChar = 'A';
        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 != 0) {
                oddCount++;
                oddChar = (char)(i + 'A');
            }
        }
        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        StringBuilder left = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < arr[i] / 2; j++) {
                left.append((char)(i + 'A'));
            }
        }
        StringBuilder result = new StringBuilder();
        result.append(left);
        StringBuilder right = left.reverse();
        if (oddCount == 1) {
            result.append(oddChar);
        }
        result.append(right);
        System.out.println(result);

    }
}
