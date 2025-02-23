package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 트리 순회 Boj1991
public class Boj1991 {

    static char[][] arr = new char[26][2];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            char root = line.charAt(0);
            char left = line.charAt(2);
            char right = line.charAt(4);

            arr[root - 'A'][0] = left;
            arr[root - 'A'][1] = right;
        }

        preOrder(0, arr[0][0], arr[0][1]);
        sb.append("\n");
        inOrder(0, arr[0][0], arr[0][1]);
        sb.append("\n");
        postOrder(0, arr[0][0], arr[0][1]);
        System.out.println(sb);
    }

    private static void preOrder(int rootIdx, char left, char right) {
        char root = (char) (rootIdx + 'A');

        sb.append(root);
        if (left != '.')
            preOrder(left - 'A', arr[left - 'A'][0], arr[left - 'A'][1]);
        if (right != '.')
            preOrder(right - 'A', arr[right - 'A'][0], arr[right - 'A'][1]);

    }
    private static void inOrder(int rootIdx, char left, char right) {
        char root = (char) (rootIdx + 'A');

        if (left != '.')
            inOrder(left - 'A', arr[left - 'A'][0], arr[left - 'A'][1]);
        sb.append(root);
        if (right != '.')
            inOrder(right - 'A', arr[right - 'A'][0], arr[right - 'A'][1]);

    }
    private static void postOrder(int rootIdx, char left, char right) {
        char root = (char) (rootIdx + 'A');

        if (left != '.')
            postOrder(left - 'A', arr[left - 'A'][0], arr[left - 'A'][1]);
        if (right != '.') {
            postOrder(right - 'A', arr[right - 'A'][0], arr[right - 'A'][1]);
        }
        sb.append(root);
    }

}
