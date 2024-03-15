package level2;

import java.util.*;

public class PhoneNum {

    public static void main(String[] args) {
        String[] phone_book = new String[]{"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));

        phone_book = new String[]{"123", "456", "789"};
        System.out.println(solution(phone_book));

        phone_book = new String[]{"12", "123", "1235", "567", "88"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);    // 하나라도 겹치면 false기 때문에 정렬후 하나씩 검사해도 됨

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {  // startsWith로 검사 ( "i + 1"을 i로 시작하는지 검사 )
                answer = false;
                return answer;
            }
        }

        /*
        * 처음 만든 코드
        * starsWith를 사용하면 더 편하다
        * 이중for문으로 하면 효율성 테스트 통과 안됨
        * */
//        for (int i = 0; i < phone_book.length - 1; i++) {
//            String s2 = "";
//            if (phone_book[i + 1].length() >= phone_book[i].length()) {
//                s2 = phone_book[i + 1].substring(0, phone_book[i].length());
//            }
//
//            if (phone_book[i].equals(s2)) {
//                answer = false;
//                return answer;
//            }
//        }

        return answer;
    }
}
