package level1;

import java.util.*;

public class KakaoPersonalityTest {

    public static void main(String[] args) {
        KakaoPersonalityTest kpt = new KakaoPersonalityTest();
        int[] choices = new int[]{5, 3, 2, 7, 5};
        String[] survey = new String[]{"AN", "CF", "MJ", "RT", "NA"};
        System.out.println(kpt.solution(survey, choices));
    }

    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> per = new HashMap<>();
        per.put("R", 0);
        per.put("T", 0);
        per.put("C", 0);
        per.put("F", 0);
        per.put("J", 0);
        per.put("M", 0);
        per.put("A", 0);
        per.put("N", 0);

        for (int i = 0; i < choices.length; i++) {
            String s1 = survey[i].substring(0, 1);
            String s2 = survey[i].substring(1);
            switch (choices[i]) {
                case 1:
                    per.put(s1, per.get(s1) + 3);
                    break;
                case 2:
                    per.put(s1, per.get(s1) + 2);
                    break;
                case 3:
                    per.put(s1, per.get(s1) + 1);
                    break;
                case 4:
                    break;
                case 5:
                    per.put(s2, per.get(s2) + 1);
                    break;
                case 6:
                    per.put(s2, per.get(s2) + 2);
                    break;
                case 7:
                    per.put(s2, per.get(s2) + 3);
                    break;
            }
        }

        answer = answer + (per.get("R") > per.get("T") ? "R" : per.get("R") < per.get("T") ? "T" : "R");
        answer = answer + (per.get("C") > per.get("F") ? "C" : per.get("C") < per.get("F") ? "F" : "C");
        answer = answer + (per.get("J") > per.get("M") ? "J" : per.get("J") < per.get("M") ? "M" : "J");
        answer = answer + (per.get("A") > per.get("N") ? "A" : per.get("A") < per.get("N") ? "N" : "A");

        return answer;
    }

}
