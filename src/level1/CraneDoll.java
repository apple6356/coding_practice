package level1;

import java.util.Stack;

public class CraneDoll {

    public static void main(String[] args) {
        CraneDoll craneDoll = new CraneDoll();
        int[][] board = {{0, 0, 0, 0, 0}
                , {0, 0, 1, 0, 3}
                , {0, 2, 5, 0, 1}
                , {4, 2, 4, 4, 2}
                , {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(craneDoll.solution(board, moves));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] != 0) {
                    if (basket.isEmpty() || basket.peek() != board[j][moves[i] - 1]){
                        basket.push(board[j][moves[i] - 1]);
                        board[j][moves[i] - 1] = 0;
                        break;
                    }
                    if (basket.peek() == board[j][moves[i] - 1]) {
                        basket.pop();
                        board[j][moves[i] - 1] = 0;
                        answer += 2;
                        break;
                    }
                }
            }
        }

        return answer;
    }

}
