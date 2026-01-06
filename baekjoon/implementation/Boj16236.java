package baekjoon.implementation;

import java.io.*;
import java.util.*;

//백준 아기 상어 Boj16236
public class Boj16236 {
    static int N;
    static int time = 0;
    static int[][] board;
    static int sharkX, sharkY;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    static int sharkSize = 2;
    static int eatCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    board[i][j] = 0;
                }
            }
        }

        while (true) {
            int[] result = findNearestFish();
            if (result == null) break;
            
            int fishX = result[0];
            int fishY = result[1];
            int distance = result[2];
            
            board[fishX][fishY] = 0;
            sharkX = fishX;
            sharkY = fishY;
            time += distance;
            eatCount++;
            
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }
        
        System.out.println(time);
    }

    private static int[] findNearestFish() {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<int[]> candidates = new ArrayList<>();
        
        queue.offer(new int[]{sharkX, sharkY, 0});
        visited[sharkX][sharkY] = true;
        
        int minDistance = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];
            
            if (dist > minDistance) break;
            
            if (board[x][y] > 0 && board[x][y] < sharkSize) {
                if (dist < minDistance) {
                    candidates.clear();
                    minDistance = dist;
                }
                if (dist == minDistance) {
                    candidates.add(new int[]{x, y, dist});
                }
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny] || board[nx][ny] > sharkSize) continue;
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dist + 1});
            }
        }
        
        if (candidates.isEmpty()) return null;
        
        candidates.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        
        return candidates.get(0);
    }
}
