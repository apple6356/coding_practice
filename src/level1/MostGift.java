package level1;

public class MostGift {

    public static void main(String[] args) {
        MostGift mg = new MostGift();
        String[] friends = new String[]{"muzi", "ryan", "frodo", "neo"};
        String[] gifts = new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(mg.solution(friends, gifts));

        friends = new String[]{"joy", "brad", "alessandro", "conan", "david"};
        gifts = new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        System.out.println(mg.solution(friends, gifts));

        friends = new String[]{"a", "b", "c"};
        gifts = new String[]{"a b", "b a", "c a", "a c", "a c", "c a"};
        System.out.println(mg.solution(friends, gifts));
    }

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        return answer;
    }
}
