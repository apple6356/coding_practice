package level1;

public class Bandage {

    public static void main(String[] args) {
        Bandage b = new Bandage();
        int[] bandage = new int[]{5, 1, 5};
        int health = 30;
        int[][] attacks = new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        System.out.println(b.solution(bandage, health, attacks));

        bandage = new int[]{3, 2, 7};
        health = 20;
        attacks = new int[][]{{1, 15}, {5, 16}, {8, 6}};
        System.out.println(b.solution(bandage, health, attacks));

        bandage = new int[]{4, 2, 7};
        health = 20;
        attacks = new int[][]{{1, 15}, {5, 16}, {8, 6}};
        System.out.println(b.solution(bandage, health, attacks));

        bandage = new int[]{1, 1, 1};
        health = 5;
        attacks = new int[][]{{1, 2}, {3, 2}};
        System.out.println(b.solution(bandage, health, attacks));
    }

    public int solution(int[] bandage, int health, int[][] attacks) {
        int currentHealth = health; // 현재 체력
        int lastAttackTime = attacks[attacks.length - 1][0];    // 마지막으로 공격받는 시간
        int straightBandage = 0;    // 연속 성공 시간
        int attackcnt = 0;  // 공격 카운트

        for (int i = 1; i <= lastAttackTime; i++) {
            // 공격당했을 때
            if (i == attacks[attackcnt][0]) {
                currentHealth -= attacks[attackcnt][1]; // 현재 체력 저하
                straightBandage = 0;    // 연속 성공 초기화
                attackcnt++;    // 공격 카운트 +1
                // 현재 체력이 0보다 작거나 같으면 -1 리턴
                if (currentHealth <= 0) {
                    return -1;
                }
                continue;   // 공격에 맞았기 때문에 체력 회복 하지 않고 다음 루프로
            } else straightBandage++;   // 공격에 맞지 않았기 때문에 연속 성공 +1

            currentHealth += bandage[1];

            // 연속 성공 시간을 채월 때 추가 체력 회복
            if (straightBandage == bandage[0]) {
                currentHealth += bandage[2];
                straightBandage = 0;
            }

            // 최대 체력을 오버할 시 최대 체력으로 고정
            if (currentHealth >= health) currentHealth = health;
        }

        return currentHealth;
    }
}
