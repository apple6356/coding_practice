package level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book.length; j++) {
                if (i == j) continue;
                String s2;
                if (phone_book[j].length() >= phone_book[i].length()) {
                    s2 = phone_book[j].substring(0, phone_book[i].length());
                } else continue;

                if (phone_book[i].equals(s2)) {
                    answer = false;
                    break;
                }
            }
            if (!answer) break;
        }

        return answer;
    }
}
