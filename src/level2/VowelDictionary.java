package level2;

import java.util.ArrayList;
import java.util.List;

// 다른 사람 풀이 보고 풀었음
public class VowelDictionary {

    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
        System.out.println(solution("AAAE"));
        System.out.println(solution("I"));
        System.out.println(solution("EIO"));
    }

    static List<String> list;   // 단어를 저장할 list
    static String[] strings = {"A", "E", "I", "O", "U"};

    public static int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();

        dfs("", 0);
        answer = list.indexOf(word);    // word의 index를 찾는다

        return answer;
    }

    public static void dfs(String str, int len) {
        list.add(str);

        if (len == 5) return;

        for (int i = 0; i < strings.length; i++) {
            dfs(str + strings[i], len + 1);
        }
    }
}
