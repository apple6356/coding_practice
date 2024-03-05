package level2;

import java.util.HashMap;
import java.util.Map;

public class Clothes {

    public static void main(String[] args) {
        Clothes c = new Clothes();
        String[][] clothes = new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(c.solution(clothes));
        clothes = new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(c.solution(clothes));

    }

    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clothesMap = new HashMap<>();

        for (String[] clothe : clothes) {
            if (clothesMap.containsKey(clothe[1])) {
                clothesMap.put(clothe[1], clothesMap.get(clothe[1]) + 1);
            } else clothesMap.put(clothe[1], 1);
        }

        // (a + 1)(b + 1)(c + 1)...(n + 1) - 1 공식을 몰라서 다른 사람 풀이 참조
        for (String key : clothesMap.keySet()) {    // key값 안 받고 i = 0 으로 돌리면 안된다.
            answer *= (clothesMap.get(key) + 1);
        }
        answer -= 1;

        return answer;
    }
}
