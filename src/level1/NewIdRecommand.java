package level1;

public class NewIdRecommand {
    public static void main(String[] args) {
        NewIdRecommand nir = new NewIdRecommand();
        System.out.println(nir.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(nir.solution("z-+.^."));
        System.out.println(nir.solution("=.="));
        System.out.println(nir.solution("123_.def"));
        System.out.println(nir.solution("abcdefghijklmn.p"));
        System.out.println(nir.solution(""));
    }

    public String solution(String new_id) {
        String  answer = new_id;

        answer = answer.toLowerCase();  // 소문자로 변경

        answer = answer.replaceAll("[^0-9a-z._-]", ""); // 숫자, 알파벳 소문자, ., -, _ 만 남기고 제거

        answer = answer.replaceAll("[.]{2,}", "."); // .이 두개 이상 연속되면 하나로 변경 ( {2, } 두개 이상이면 하라는 뜻 )

        answer = answer.replaceAll("^[.]|[.]$", "");    // .이 맨 앞이나 뒤에 있으면 제거 ^는 문자열 앞, $는 뒤

        if (answer.isEmpty()) answer = "a"; // 문자열 비었으면 a 삽입

        if (answer.length() >= 16) answer = answer.substring(0, 15);    // 아이디가 16자가 넘어가면 15자로 줄인다.
        answer = answer.replaceAll("[.]$", ""); // 15자로 줄인후 제일 뒤에 .이 있으면 제거

        // 문자열이 2이하면 실행
        if (answer.length() <= 2) {
            // 문자열의 가장 뒤 문자를 문자열이 3이 될때까지 반복
            for (int i = answer.length(); i < 3; i++) {
                answer = answer + answer.charAt(answer.length() - 1);
            }
        }

        return answer;
    }
}
