package level2;

public class TargetNumber {

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 1, 1, 1, 1};
        System.out.println(solution(numbers, 3));

        numbers = new int[]{4, 1, 2, 1};
        System.out.println(solution(numbers, 4));
    }

    static int answer;
    static int sum;

    public static int solution(int[] numbers, int target) {
        answer = 0;
        sum = 0;

        dfs(sum, 0, numbers, target);

        return answer;
    }

    // 다른 사람 풀이 참조해서 풀었음
    // 재귀 함수 사용, sum은 합, depth는 numbers의 index 표시
    public static void dfs(int sum, int depth, int[] numbers, int target) {
        if (depth == numbers.length) {  // 마지막 노드에 도달하면 return
            if (sum == target) answer++;    // sum이 target과 같으면 answer + 1
            return;
        }

        // +, - 각각 재귀해 탐색
        dfs(sum + numbers[depth], depth + 1, numbers, target);
        dfs(sum - numbers[depth], depth + 1, numbers, target);
    }
}
