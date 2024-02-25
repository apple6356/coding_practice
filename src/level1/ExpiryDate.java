package level1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ExpiryDate {

    public static void main(String[] args) {
        ExpiryDate ed = new ExpiryDate();
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(Arrays.toString(ed.solution("2022.05.19", terms, privacies)));

        terms = new String[]{"Z 3", "D 5"};
        privacies = new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        System.out.println(Arrays.toString(ed.solution("2020.01.01", terms, privacies)));

        terms = new String[]{"A 1"};
        privacies = new String[]{"2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.01 A"};
        System.out.println(Arrays.toString(ed.solution("2020.01.01", terms, privacies)));
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        List<Integer> des = new ArrayList<>();

        // String 타입인 today를 LocalDate 타입으로 변경
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, formatter);

        // terms를 Map형태로 저장
        Map<String, Integer> termMap = new HashMap<>();
        for (String s : terms) {
            termMap.put(s.replaceAll("[^A-Z]", ""),
                    Integer.parseInt(s.replaceAll("[^0-9]", "")));
        }

        for (int i = 0; i < privacies.length; i++) {
            // privacies에 있는 날짜를 LocalDate로 변경
            LocalDate privDate = LocalDate.parse(privacies[i].replaceAll("[A-Z\\s]", ""), formatter);
            // 유효기간만큼 Month+   참고 : https://velog.io/@ow1011/LocalDate-%EB%A9%94%EC%84%9C%EB%93%9C-%EC%A0%95%EB%A6%AC
            privDate = privDate.plusMonths(termMap.get(privacies[i].replaceAll("[^A-Z]", "")));
            // 유효기간에 -1을 해 개인정보 폐기날짜 구하기
            privDate = privDate.minusDays(1);

            // 오늘 날짜와 개인정보 폐기일을 비교해 des List에 삽입
            if (privDate.isBefore(todayDate)) {
                des.add(i + 1);
            }
        }

        answer = new int[des.size()];
        for (int i = 0; i < des.size(); i++) {
            answer[i] = des.get(i);
        }

        return answer;
    }

}
