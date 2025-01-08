import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                cnt += i;
            }
        }
        System.out.println(cnt);

    }
}