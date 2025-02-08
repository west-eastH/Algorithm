package implementation;

import java.io.*;
import java.util.*;

//나동빈 상하좌우
public class ImplementationEx01 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static final char[] moves = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int x = 1, y = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            char dir = st.nextToken().charAt(0);
            int dirIndex = 0;
            for (int i = 0; i < 4; i++) {
                if (moves[i] == dir) {
                    dirIndex = i;
                    break;
                }
            }

            int nx = x + dx[dirIndex];
            int ny = y + dy[dirIndex];

            if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
                x = nx;
                y = ny;
            }
        }

        System.out.println(x + " " + y);
    }
}
