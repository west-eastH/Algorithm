package programmers.level1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//프로그래머스 Level1 개인정보 수집 유효기간
class Solution18 {

    public int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> expired = new ArrayList<>();
        Map<Character, Integer> termMap = new HashMap<>();
        LocalDate todayDate = strToDate(today);

        for (String term : terms) {
            String[] parts = term.split(" ");
            termMap.put(parts[0].charAt(0), Integer.parseInt(parts[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            LocalDate expriryDate = strToDate(parts[0]).plusMonths(termMap.get(parts[1].charAt(0)))
                .minusDays(1);

            if (todayDate.isAfter(expriryDate)) {
                expired.add(i + 1);
            }
        }

        return expired.stream().mapToInt(i -> i).toArray();
    }

    public static LocalDate strToDate(String str) {
        String[] dateArr = str.split("\\.");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);
        LocalDate localDate = LocalDate.of(year, month, day);

        return localDate;
    }
}