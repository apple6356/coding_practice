package level1;

import java.util.*;

public class Ponketmon {

    public static void main(String[] args) {
        Ponketmon ponketmon = new Ponketmon();
        int[] nums = {3, 3, 3, 2, 2, 4};
        System.out.println(ponketmon.solution(nums));
    }

    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; set.size() > (nums.length / 2); i++) {
            set.remove(i);
        }

        return answer = set.size();
    }

}
