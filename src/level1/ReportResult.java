package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReportResult {

    public static void main(String[] args) {
        ReportResult rr = new ReportResult();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        System.out.println(Arrays.toString(rr.solution(id_list, report, 2)));

        id_list = new String[]{"con", "ryan"};
        report = new String[]{"ryan con", "ryan con", "ryan con", "ryan con"};
        System.out.println(Arrays.toString(rr.solution(id_list, report, 3)));
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, ArrayList<String>> reportIdMap = new HashMap<>();
        Map<String, Integer> reportCountMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            reportIdMap.put(id_list[i], new ArrayList<>());
            reportCountMap.put(id_list[i], 0);
        }

        for (int i = 0; i < report.length; i++) {
            String[] reportSplit = report[i].split(" ");
            String reporter = reportSplit[0];
            String reported = reportSplit[1];

            if (reportIdMap.get(reporter).contains(reported)) {
                continue;
            } else {
                reportCountMap.put(reported, reportCountMap.get(reported) + 1);
                reportIdMap.get(reporter).add(reported);
            }

            System.out.println("reportIdMap = " + reportIdMap.get(reporter));
            System.out.println("reporter = " + reporter);
            System.out.println("reported = " + reported);
        }

        for (int i = 0; i < id_list.length; i++) {
            if (reportCountMap.get(id_list[i]) >= 2) {

            }
        }

        return answer;
    }

}
