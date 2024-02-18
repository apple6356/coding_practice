package level1;

public class BoardColor {

    public static void main(String[] args) {
        BoardColor boardColor = new BoardColor();
        String[][] board = {{"blue", "red", "orange", "red"}
                , {"red", "red", "blue", "orange"}
                , {"blue", "orange", "red", "red"}
                , {"orange", "orange", "red", "blue"}};
        System.out.println(boardColor.solution(board, 1, 1));
    }

    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};

        for (int i = 0; i <= 3; i++) {
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            if (0 <= h_check && h_check < n && 0 <= w_check && w_check < n) {
                if (board[h][w].equals(board[h_check][w_check])) answer++;
            }
        }

        return answer;
    }

}
