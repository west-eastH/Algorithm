package implementation;

/*
 * name type rentable
 * piano atype yes
 * desk btype no
 * */

//소마 기출 문제
public class SoftwareMaestro {

    static int col = 0;

    public static void main(String[] args) {
        String[] sArr = {"name type rentable", "piano atype yes", "computer atype yes",
            "desk btype no"};
        String search = "type atype name computer";

        String[] temp = sArr[0].split(" ");
        col = temp.length;

        int answer = solution(sArr, search);
        System.out.println(answer);

    }

    public static int solution(String[] sArr, String search) {

        int result = 0;

        String[] option = search.split(" ");

        int idx = -1;

        for (int i = 0; i < option.length; i += 2) {
            result += find(sArr, option, i, 0);
        }

        return result;
    }

    public static int find(String[] arr, String[] option, int m, int depth) {
        int result = 0;

        String column = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (check(arr[i], option, m, depth, column)) {
                result++;
            }
        }
        return result;
    }

    private static boolean check(String str, String[] option, int m, int depth, String column) {
        if (m < depth) {
            return true;
        }
        int idx = getIdx(option[depth], column);
        String[] temp = str.split(" ");
        if (temp[idx].equals(option[depth + 1])) {
            return check(str, option, m, depth + 2, column);
        }

        return false;

    }

    public static int getIdx(String str, String col) {

        String[] temp = col.split(" ");
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

}
