package level1;

public class MidCharacter {

    public static void main(String[] args) {
        MidCharacter mc = new MidCharacter();
        System.out.println(mc.solution("abcde"));
    }

    public String solution(String s) {
        String answer = "";

        if((s.length() % 2) == 0) {
            answer = s.substring((s.length()/2)-1, (s.length()/2)+1);
        }
        else {
            answer = s.substring((s.length() / 2), (s.length() / 2) + 1);
        }

        return answer;
    }

}
