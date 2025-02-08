package string;

import java.io.*;

//백준 암호해독 14584
public class Boj14584 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        for (int shift = 0; shift < 26; shift++) {
            String decoded = decode(str, shift);

            for (String word : words) {
                if (decoded.contains(word)) {
                    System.out.println(decoded);
                    return;
                }
            }
        }
    }

    private static String decode(String str, int shift) {
        char[] result = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            int newChar = str.charAt(i) - shift;
            if (newChar < 'a') {
                newChar += 26;
            }
            result[i] = (char)newChar;
        }

        return new String(result);
    }
}


