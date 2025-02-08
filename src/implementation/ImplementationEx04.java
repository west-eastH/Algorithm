package implementation;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//나동빈 문자열 재정렬
public class ImplementationEx04 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        ArrayList<Character> list = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c >= '0' && c <= '9') {
                num += c - '0';
            }
            else {
                list.add(c);
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        sb.append(num);
        System.out.println(sb.toString());
    }
}
