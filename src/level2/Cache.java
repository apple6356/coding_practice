package level2;

import java.util.*;

public class Cache {

    public static void main(String[] args) {
        Cache cache = new Cache();
        String[] cities = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(cache.solution(3, cities));
        cities = new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        System.out.println(cache.solution(3, cities));
        cities = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        System.out.println(cache.solution(2, cities));
        cities = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        System.out.println(cache.solution(5, cities));
        cities = new String[]{"Jeju", "Pangyo", "NewYork", "newyork"};
        System.out.println(cache.solution(2, cities));
        cities = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(cache.solution(0, cities));
    }

    public int solution(int cacheSize, String[] cities) {
        // LRU 알고리즘 사용 ( 가장 오랫동안 사용되지 않은 페이지를 교체하는 기법 )
        int answer = 0;
        List<String> cacheList = new LinkedList<>();    // 캐시

        for (String city : cities) {
            // 대소문을 구분하지 않기 때문에 모두 소문자로 변환
            city = city.toLowerCase();

            // cache hit
            if (cacheList.contains(city)) {
                answer += 1;
                // 캐시 사용 후 해당 데이터를 연결 리스트 제일 뒤로 옮겨서 최근 사용을 표시
                cacheList.remove(city);
                cacheList.add(city);
            } else {
                answer += 5;
                // 캐시 사용 후 해당 데이터를 연결 리스트 제일 뒤로 옮겨서 최근 사용을 표시
                cacheList.remove(city);
                cacheList.add(city);
                // 캐시리스트의 크기가 cacheSize보다 크면 제일 앞쪽 데이터 삭제
                if (cacheList.size() > cacheSize) {
                    cacheList.remove(0);
                }
            }
        }

        return answer;
    }
}
