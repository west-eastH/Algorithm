package implementation;
import java.io.*;

//나동빈 시각
public class ImplementationEx02 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    if (i == 3 || i == 13 || j / 10 == 3 || j % 10 == 3 || k / 10 == 3
                        || k % 10 == 3) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
