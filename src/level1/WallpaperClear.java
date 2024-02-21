package level1;

import java.util.Arrays;

public class WallpaperClear {

    public static void main(String[] args) {
        WallpaperClear wc = new WallpaperClear();
        String[] str = {".#...", "..#..", "...#."};
        System.out.println(Arrays.toString(wc.solution(str)));

        str = new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."};
        System.out.println(Arrays.toString(wc.solution(str)));

        str = new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        System.out.println(Arrays.toString(wc.solution(str)));

        str = new String[]{"..", "#."};
        System.out.println(Arrays.toString(wc.solution(str)));
    }

    // 2차 풀이 다른 사람 풀이 참고
    public int[] solution(String[] wallpaper) {
        int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    if (answer[0] > i) answer[0] = i;
                    if (answer[1] > j) answer[1] = j;
                    if (answer[2] < i + 1) answer[2] = i + 1;
                    if (answer[3] < j + 1) answer[3] = j + 1;
                }
            }
        }

        return answer;
    }

    /* 1 차 풀이
    public int[] solution(String[] wallpaper) {
        int[] answer = {0, 0, wallpaper.length, wallpaper[0].length()};
        boolean check = true;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') check = false;
            }
            if (check) {
                answer[0]++;
            } else break;
        }

        check = true;
        for (int i = 0; i < wallpaper[0].length(); i++) {
            for (int j = 0; j < wallpaper.length; j++) {
                if (wallpaper[j].charAt(i) == '#') check = false;
            }
            if (check) {
                answer[1]++;
            } else break;
        }

        check = true;
        for (int i = wallpaper.length - 1; i >= 0; i--) {
            for (int j = wallpaper[0].length() - 1; j >= 0; j--) {
                if (wallpaper[i].charAt(j) == '#') check = false;
            }
            if (check) {
                answer[2]--;
            } else break;
        }

        check = true;
        for (int i = wallpaper[0].length() - 1; i >= 0; i--) {
            for (int j = wallpaper.length - 1; j >= 0; j--) {
                if (wallpaper[j].charAt(i) == '#') check = false;
            }
            if (check) {
                answer[3]--;
            } else break;
        }

        return answer;
    }*/

}
