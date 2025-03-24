package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraEx02 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[101][101];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], (int) 1e9);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int distance = graph[1][k] + graph[k][x];

        if (distance >= (int)1e9) {
            System.out.println(-1);
        }
        else {
            System.out.println(distance);
        }
    }
}
