import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // 캐시 크기가 0일 때
        if (cacheSize == 0) {
            return 5 * cities.length;
        }
        // 저장되어 있는 캐시
        ArrayList<String> used_cache = new ArrayList<>();
        // 실행 시간
        int answer = 0;
        st : for (String city: cities) {
            for (int i = 0; i < used_cache.size(); ++i) {
                // 만약 저장되어 있을 때
                if (city.equalsIgnoreCase(used_cache.get(i))) {
                    // 1초++
                    answer++;
                    // 최근 사용으로 갱신
                    used_cache.remove(i);
                    used_cache.add(city);            
                    continue st;
                }
            }
            // 저장되어 있지 않을 때 5초++
            answer += 5;
            // 만약 캐시가 꽉 차 있다면
            if (used_cache.size() >= cacheSize) {
                // 오래된 것 삭제
                used_cache.remove(0);
                // 새로운 것 추가
                used_cache.add(city);
            }
            // 저장 공간이 남았을 때
            else {
                used_cache.add(city);
            }
        }
        return answer;
    }
}