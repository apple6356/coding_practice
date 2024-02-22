package level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        String des = "";

        String[] todayStr = today.split("\\.");
        int todayYear = Integer.parseInt(todayStr[0]);
        int todayMonth = Integer.parseInt(todayStr[1]);
        int todayDay = Integer.parseInt(todayStr[2]);

        Map<String, Integer> termMap = new HashMap<>();
        for (String s : terms) {
            termMap.put(s.replaceAll("[^A-Z]", ""),
                    Integer.parseInt(s.replaceAll("[^0-9]", "")));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privDate = privacies[i].replaceAll("[A-Z\\s]", "").split("\\.");
            int privYear = Integer.parseInt(privDate[0]);
            int privMonth = Integer.parseInt(privDate[1]);
            int privDay = Integer.parseInt(privDate[2]);

            int diff = 0;
            diff += (todayYear - privYear) * (28 * 12);
            diff += (todayMonth - privMonth) * 28;
            int termInt = (termMap.get(privacies[i].replaceAll("[^A-Z]", "")) * 28);

            if (diff > termInt) des += i;
            else if (privDay == 1) {

            } else if (diff == termInt && todayDay >= privDay) des += i;
        }

        answer = new int[des.length()];
        for (int i = 0; i < des.length(); i++) {
            answer[i] = (des.charAt(i) - '0') + 1;
        }

        return answer;
    }

}
