package level1;

import java.util.*;

public class DataAnalysis {

    public static void main(String[] args) {
        DataAnalysis DA = new DataAnalysis();
        int[][] data = {{1, 20300104, 100, 80}
                , {2, 20300804, 847, 37}
                , {3, 20300401, 10, 8}};
        System.out.println(Arrays.toString(DA.solution(data, "date", 20300501, "remain")));

    }

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer;
        String[] str = {"code", "date", "maximum", "remain"};
        int extNum = -1;    // 비교하는 변수
        int sortNum = -1;   // 정렬하는 변수
        ArrayList<int []> list = new ArrayList<>();

        // 비교용 변수와 정렬용 변수 변환
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(ext)) extNum = i;

            if (str[i].equals(sort_by)) sortNum = i;
        }

        // list에 조건을 만족하는 배열 저장
        for (int[] dataArr : data) {
            if (dataArr[extNum] < val_ext) {
                list.add(dataArr);
            }
        }

        int sNum = sortNum;
        list.sort(Comparator.comparingInt(o -> o[sNum]));   // list를 정렬 기준에 맞춰 정렬
        answer = new int[list.size()][];

        // answer에 list삽입
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
