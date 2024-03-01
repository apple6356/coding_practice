package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordChain {

    public static void main(String[] args) {
        WordChain wc = new WordChain();
        String[] words = new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(Arrays.toString(wc.solution(3, words)));

        words = new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        System.out.println(Arrays.toString(wc.solution(5, words)));

        words = new String[]{"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(Arrays.toString(wc.solution(2, words)));
    }

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> wordList = new ArrayList<>();  // 단어를 담을 list contains로 중복 체크
        int cycle = 0;  // 차례가 몇번 돌았는지

        for (int i = 0; i < words.length; i++) {
            cycle = (i / n) + 1;

            if (i == 0) {
                wordList.add(words[i]);
            } else if (wordList.contains(words[i]) || words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                answer[0] = ((i + 1) % n) != 0 ? ((i + 1) % n) : n;
                answer[1] = cycle;
                break;
            } else wordList.add(words[i]);

        }

        return answer;
    }

}
