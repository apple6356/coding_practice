package level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        Map<String, Integer> giftIndex = new HashMap<>();   // 이름, 선물 지수
        Map<String, Integer> giftGet = new HashMap<>();     // 이름, 받을 선물 수
        Map<String, Integer> friendsIndex = new HashMap<>();    // 이름, 이름에 따른 인덱스
        int[][] giftNum = new int[friends.length][friends.length];  // 선물을 주고 받은 수를 저장한 2차원 배열

        // Map 초기화
        for (int i = 0; i < friends.length; i++) {
            giftIndex.put(friends[i], 0);
            giftGet.put(friends[i], 0);
            friendsIndex.put(friends[i], i);
        }

        for (int i = 0; i < gifts.length; i++) {
            String[] giftSpilt = gifts[i].split(" ");
            String giftGive = giftSpilt[0];
            String giftTake = giftSpilt[1];

            giftNum[friendsIndex.get(giftGive)][friendsIndex.get(giftTake)]++;
            giftIndex.put(giftGive, giftIndex.get(giftGive) + 1);
            giftIndex.put(giftTake, giftIndex.get(giftTake) - 1);

        }

        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                int x = friendsIndex.get(friends[i]);
                int y = friendsIndex.get(friends[j]);

                if (giftNum[x][y] == giftNum[y][x]) {
                    if (giftIndex.get(friends[i]) == giftIndex.get(friends[j])) continue;
                    if (giftIndex.get(friends[i]) > giftIndex.get(friends[j]))
                        giftGet.put(friends[i], giftGet.get(friends[i]) + 1);
                    else if (giftIndex.get(friends[i]) < giftIndex.get(friends[j]))
                        giftGet.put(friends[j], giftGet.get(friends[j]) + 1);
                } else if (giftNum[x][y] > giftNum[y][x]) {
                    giftGet.put(friends[i], giftGet.get(friends[i]) + 1);
                } else if (giftNum[x][y] < giftNum[y][x]) {
                    giftGet.put(friends[j], giftGet.get(friends[j]) + 1);
                }
            }
        }

        answer = giftGet.get(friends[0]);
        for (int i = 1; i < giftGet.size(); i++) {
            if (giftGet.get(friends[i]) > answer) answer = giftGet.get(friends[i]);
        }

        return answer;
    }
}
