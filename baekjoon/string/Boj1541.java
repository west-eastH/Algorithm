package baekjoon.string;

import java.io.*;

//백준 잃어버린 괄호 Boj1541
public class Boj1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] temp = str.split("-");
        int result = calculate(temp[0]);
        for (int i = 1; i < temp.length; i++) {
            result -= calculate(temp[i]);
        }
        System.out.println(result);
    }

    private static int calculate(String s) {
        String[] nums = s.split("\\+");
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += Integer.parseInt(nums[i]);
        }
        return result;
    }


}
