package level2;


// 다른 사람 풀이 참조해서 풀었음
public class Fatigability {

    public static void main(String[] args) {
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(solution(80, dungeons));
    }

    static int answer;
    static boolean[] visited;   // 방문여부

    public static int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);

        return answer;
    }

    // depth는 현재 탐색한 던전 수
    public static void dfs(int depth, int k, int[][] dugeons) {
        for (int i = 0; i < dugeons.length; i++) {
            System.out.println("visited = " + visited[i] + ", depth = " + depth);
            if (visited[i] || dugeons[i][0] > k) continue;  // 이미 방문했거나, 피로도가 부족하면 넘긴다
            visited[i] = true;  // 방문 처리
            dfs(depth + 1, k - dugeons[i][1], dugeons); // 재귀, depth++ 사용시 depth 변수 자체의 값이 변경됨
            visited[i] = false;
        }

        answer = Math.max(answer, depth);
        System.out.println("answer = " + answer);
    }

}
