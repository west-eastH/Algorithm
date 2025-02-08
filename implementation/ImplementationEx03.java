package implementation;
import java.io.*;
import java.util.StringTokenizer;

//나동빈 왕실의 나이트
public class ImplementationEx03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

        int x = line.charAt(0) - 'a' + 1;
        int y = line.charAt(1) - '0';
        int result = 0;
        for (int i = 0; i <8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 1 || ny < 1 || nx > 8 || ny > 8)
                continue;
            result++;
        }
        System.out.println(result);
    }
}
