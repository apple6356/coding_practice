package level1;

public class NumsString {
    public static void main(String[] args) {
        NumsString ns = new NumsString();
        String str = "one4seveneight";
        System.out.println(ns.solution(str));
    }

    public int solution(String s) {
        int answer = 0;

        String[] en = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < en.length; i++) {
            s = s.replace(en[i], Integer.toString(i));
        }

        return answer = Integer.parseInt(s);
    }
}
