package level2;

import java.sql.Array;
import java.util.*;

public class Lifeboat {

    public static void main(String[] args) {
        Lifeboat lifeboat = new Lifeboat();
        int[] people = new int[]{70, 50, 80, 50};
        System.out.println(lifeboat.solution(people, 100));

        people = new int[]{70, 80, 50};
        System.out.println(lifeboat.solution(people, 100));
    }

    // 다른 사람 풀이 참조해서 풀었음 ( 효율성 테스트 통과하지 못해서 )
    public int solution(int[] people, int limit) {
        int answer = 0;
        int L = 0;
        Arrays.sort(people);

        for (int i = (people.length - 1); i >= L; i--) {
            if (people[i] + people[L] <= limit) {
                L++;
                answer++;
            } else {
                answer++;
            }
        }

        return answer;
    }

}
