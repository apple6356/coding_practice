package level1;

import java.util.Arrays;

public class SecretMap {

    public static void main(String[] args) {
        SecretMap sm = new SecretMap();
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        System.out.println("Arrays.toString(sm.solution()) = " + Arrays.toString(sm.solution(n, arr1, arr2)));
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String blockStr = "";
             /**
              * String.format으로 자릿수를 맞춘다.
              * Integer.toBinaryString으로 10진수 정수를 2진수로 바꿔준다.
              * replace로 자릿수를 바꾸며 생긴 공백을 0으로 채워준다.
              */
            String binaryStr1 = String.format("%"+n+"s", Integer.toBinaryString(arr1[i])).replace(" ", "0");
            String binaryStr2 = String.format("%"+n+"s", Integer.toBinaryString(arr2[i])).replace(" ", "0");
            for (int j = 0; j < n; j++) {
                if ((binaryStr1.charAt(j) - '0') == 0 && (binaryStr2.charAt(j) - '0') == 0) {
                    blockStr += " ";
                }
                if ((binaryStr1.charAt(j) - '0') == 1 || (binaryStr2.charAt(j) - '0') == 1) {
                    blockStr += "#";
                }
            }
            answer[i] = blockStr;
        }

        return answer;
    }
    
}
