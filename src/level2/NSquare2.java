package level2;

import java.util.Arrays;

public class NSquare2 {

    public static void main(String[] args) {
        NSquare2 ns = new NSquare2();
        System.out.println(Arrays.toString(ns.solution(3, 2, 5)));
        System.out.println(Arrays.toString(ns.solution(4, 7, 14)));
        System.out.println(Arrays.toString(ns.solution(3, 3, 4)));
    }

    public int[] solution(int n, long left, long right) {
        int m = (int) (right - left);   // 구해야하는 수의 크기
        int[] answer = new int[m + 1];
//        int[] arr2 = new int[n * n];  // 배열이 너무 커져서 사용하지 않아야함

        /*
            행렬의 좌표를 구해서 좌표의 x, y 중 더 큰 값에 +1 을 하면 답이 된다.
            ex) 구한 좌표값 [0, 2] 라면 더 큰값에 1을 더해서 3을 삽입하면된다.
            좌표값을 구하는것은 해당 인덱스값 / 행 크기 로 로우값을 구하고
            인덱스 % 행 으로 컬럼값을 구한다.
         */
        for (int i = 0; i <= m; i++) {
            int row = (int) ((left + i) / n);
            int column = (int) ((left + i) % n);
            answer[i] = Math.max(row, column) + 1;
        }

//        처음 만든 코드
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                int max = Math.max(i, j);
//                arr2[idx++] = max + 1;
//            }
//        }
//
//        for (int i = 0; i <= m; i++) {
//            answer[i] = arr2[(int) left + i];
//        }

        return answer;
    }
}
