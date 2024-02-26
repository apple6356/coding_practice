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

        id_list = new String[]{"a", "b", "c", "d"};
        report = new String[]{"a b", "a b", "c a", "d a", "a b", "c d", "a d", "b c", "b a", "d a"};
        System.out.println(Arrays.toString(rr.solution(id_list, report, 2)));
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // <신고 당한 사람, 신고한 사람 리스트>
        Map<String, ArrayList<String>> reportIdMap = new HashMap<>();
        // <신고한 사람, 그 사람의 식별 번호>
        Map<String, Integer> reportNumMap = new HashMap<>();

        // 배열과 Map들 초기화
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = 0;
            reportIdMap.put(id_list[i], new ArrayList<>());
            reportNumMap.put(id_list[i], i);
        }

        // 신고 처리
        for (int i = 0; i < report.length; i++) {
            String[] reportSplit = report[i].split(" ");
            String reporter = reportSplit[0];
            String reported = reportSplit[1];

            // 한 사람을 같은 사람이 두번 이상 신고하면 continue
            if (reportIdMap.get(reported).contains(reporter)) {
                continue;
            } else {    // 첫 신고라면 신고한 사람이 누구 인지 저장
                reportIdMap.get(reported).add(reporter);
            }
        }

        // 신고한 사람이 결과를 몇 번 받는지 정리
        for (int i = 0; i < id_list.length; i++) {
            // k보다 신고를 적게 받았으면 다음으로
            if (reportIdMap.get(id_list[i]).size() >= k) {
                // 신고를 k번 이상 받았다면 신고자에게 결과 +1
                for (int j = 0; j < reportIdMap.get(id_list[i]).size(); j++) {
                    answer[reportNumMap.get(reportIdMap.get(id_list[i]).get(j))]++;
                }
            }
        }

        return answer;
    }

}
