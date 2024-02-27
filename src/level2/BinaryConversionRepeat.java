package level2;

import java.util.Arrays;

public class BinaryConversionRepeat {

    public static void main(String[] args) {
        BinaryConversionRepeat bcr = new BinaryConversionRepeat();
        System.out.println(Arrays.toString(bcr.solution("110010101001")));
        System.out.println(Arrays.toString(bcr.solution("01110")));
        System.out.println(Arrays.toString(bcr.solution("1111111")));
    }

    public int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            int zeroCount = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') zeroCount++;
            }

            answer[1] += zeroCount;
            answer[0]++;

            s = s.replaceAll("0", "");  // 0 제거
            s = Integer.toBinaryString(s.length()); // 이진변환
        }

        return answer;
    }

}
