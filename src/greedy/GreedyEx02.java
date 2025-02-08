package greedy;

import java.io.*;
import java.util.*;

//나동빈 모험가 길드
public class GreedyEx02 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int result = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += 1;
            if (cnt >= list.get(i)) {
                cnt = 0;
                result++;
            }
        }
        System.out.println(result);
    }
}
