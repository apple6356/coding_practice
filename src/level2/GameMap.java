package level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 다른 사람 풀이 참고 해서 풀었음
public class GameMap {

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(solution(maps));
        maps = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
        System.out.println(solution(maps));
    }

    static boolean[][] visited;
    static int answer;

    public static int solution(int[][] maps) {
        answer = -1;
        visited = new boolean[maps.length][maps[0].length];

        bfs(maps, 0, 0);

        return answer;
    }

    public static void bfs(int[][] maps, int x, int y) {
        // 각 방향으로 탐색
        int[] xArr = {1, 0, -1, 0};
        int[] yArr = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();

        // queue의 구조 (x y count)
        queue.offer(new int[]{x, y, 1});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            // poll = 큐의 제일 앞 정보를 가져온후 삭제
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int count = current[2];

            // 목표 지점에 도달하면 answer에 저장
            if (cx == maps.length - 1 && cy == maps[0].length - 1) {
                answer = count;
                break;
            }

            // 현 위치에서 각 방향으로 탐색
            for (int i = 0; i < 4; i++) {
                int xx = cx + xArr[i];
                int yy = cy + yArr[i];

                // maps를 벗어나면 다음으로
                if (xx < 0 || xx > maps.length - 1 || yy < 0 || yy > maps[0].length - 1)
                    continue;

                if (!visited[xx][yy] && maps[xx][yy] == 1) {
                    visited[xx][yy] = true;
                    queue.offer(new int[]{xx, yy, count + 1});
                }
            }
        }
    }
}
