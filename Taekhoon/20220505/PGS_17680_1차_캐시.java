package programmers;

// [1차 캐시] 문제는 캐시 교체 알고리즘 LRU를 알아야되는데 인터넷 검색해서 푸시오
public class PGS_17680_1차_캐시 {
	
	
	
	
	public static int solution(int cacheSize, String[] cities) {
		
		if(cacheSize == 0) { // 캐시사이즈 0 이면 전부 miss이므로 도시 개수 * 5 리턴
			return 5 * cities.length;
		}
		
		// 대소문자 구분 하면 안되므로 전부 대문자로 통일
		for(int i = 0 ; i < cities.length;i++) {
			cities[i] = cities[i].toUpperCase();
		}
		
		
		// 도시 이름들이 저장될 캐시
		String[] cache = new String[cacheSize];
		
		int answer = 0; // 정답 초기화
		
		// 입력받은 도시들을 한바퀴 순회
		for(int i = 0; i < cities.length;i++) {
			
			// i번째 도시가 캐시에 있는지 없는지(있으면 true)
			boolean contain = false;
			
			// i번째 도시가 캐시에 있는지 확인 시작
			for(int j = 0; j < cacheSize; j++) {
				// 도시가 캐시에 있으면
				if(cities[i].equals(cache[j])) {
					// 해당 도시를 0번으로 옮기고 나머지 도시들 오른쪽으로 한칸씩 이동
					String temp = cache[j];
					for(int k = j; k >= 1; k--) {
						cache[k] = cache[k-1];
					}
					cache[0] = temp;
					
					// hit상황이므로 실행시간 1 증가
					answer += 1;
					// i번째 도시가 캐시에 있는 상황이므로 contain값 true로 해서 51번째줄 if문 실행안되도록
					contain = true;
					break;
				}
			}
			// 이 경우엔 캐시에 i번째 도시가 없으므로 캐시의 0번 인덱스에 i번째 도시 넣고 나머지 오른쪽으로 이동
			if(!contain) {
				for(int j = cacheSize-1 ; j >=1 ; j--) {
					cache[j] = cache[j-1];
				}
				cache[0] = cities[i];
				answer += 5; // miss이므로 실행시간 5 증가
			}
			
		}
		return answer;
	}
}
