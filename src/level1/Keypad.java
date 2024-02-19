package level1;

import java.util.*;

public class Keypad {

    public static void main(String[] args) {
        Keypad keypad = new Keypad();
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        System.out.println(keypad.solution(numbers, hand));

        numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        hand = "right";
        System.out.println(keypad.solution(numbers, hand));

        numbers = new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        hand = "right";
        System.out.println(keypad.solution(numbers, hand));
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int left = 10;
        int right = 12;

        Map<Integer, int[]> numpad = new HashMap<>();   // 키패드의 좌표를 저장
        int n = 1;

        // 키패드 좌표를 numpad에 저장, 편의상 *, 0, #을 각각 10, 11, 12로 저장
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                numpad.put(n++, new int[]{i, j});
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {    // 1, 4, 7 일 때 수행
                answer.append("L");
                left = numbers[i];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) { // 3, 6, 9 일 때 수행
                answer.append("R");
                right = numbers[i];
            } else {
                if(numbers[i] == 0) numbers[i] = 11;    // 편의상 0을 11로 변경

                // 왼손이 가까운지 오른손이 가까운지 계산
                int leftDistance = getDistance(numpad.get(left), numpad.get(numbers[i]));
                int rightDistance = getDistance(numpad.get(right), numpad.get(numbers[i]));

                if (leftDistance == rightDistance) {
                    answer.append(hand.toUpperCase().charAt(0));
                    if(hand.equals("left")) left = numbers[i];
                    else right = numbers[i];
                } else if (leftDistance < rightDistance) {
                    answer.append("L");
                    left = numbers[i];
                } else {
                    answer.append("R");
                    right = numbers[i];
                }
            }
        }

        return answer.toString();
    }

    // 현재 위치와 목표 위치와의 거리를 맨해튼 거리로 계산 (맨해튼 거리 공식 |x1 - x2| + |y1 - y2|)
    public int getDistance(int[] current, int[] target) {
        int xResult = Math.abs(current[1] - target[1]) ;    // Math.abs()는 절대값을 구한다.
        int yResult = Math.abs(current[0] - target[0]);

        return xResult + yResult;
    }
}
