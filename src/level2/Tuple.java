package level2;

import java.util.*;

public class Tuple {

    public static void main(String[] args) {
        Tuple tuple = new Tuple();
        System.out.println(Arrays.toString(tuple.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(tuple.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(tuple.solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(tuple.solution("{{123}}")));
        System.out.println(Arrays.toString(tuple.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }

    public int[] solution(String s) {
        int[] answer = {};
        Set<Integer> set = new LinkedHashSet<>();

        // 앞 뒤 괄호 제거
        s = s.substring(2, s.length() - 2);

        // },{ 로 스플릿해서 배열 생성
        String[] str = s.split("},\\{");

        // 배열의 크기 순으로 정렬
        for (int i = 0; i < str.length; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (str[i].length() > str[j].length()) {
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }

        // 중복이 허용되지 않는 set의 특성 이용
        for (int i = 0; i < str.length; i++) {
            String[] s1 = str[i].split(",");
            for (int j = 0; j < s1.length; j++) {
                set.add(Integer.parseInt(s1[j]));
            }
        }

        // set을 배열로 변환해 저장
        answer = set.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
