package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int B = Integer.parseInt(st1.nextToken());
		
		int[][] myMap = new int[N][M];
		
		int maxHeight = 0; // 입력받은 블럭 중 가장 높은 값
		
		// 맵 입력 받기
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st2.nextToken());
				if (temp > maxHeight)
					maxHeight = temp;
				myMap[i][j] = temp;
			}
		}
		
		// 최소시간
		int ansTime = Integer.MAX_VALUE;

		// 그때의 높이
		int ansHeight = 0;
		
		outer: for (int targetH = 0; targetH <= maxHeight; targetH++) {
			int time = 0; // 걸리는 시간 초기화
			int block = B; // 갖고 있는 블럭개수 초기화
			
			// 빼기 작업
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (myMap[i][j] > targetH) {
						block += (myMap[i][j] - targetH); // 뺀 만큼 인벤토리에 추가
						time += (myMap[i][j] - targetH) * 2; // 시간 계산
					}
				}
			}

			// 더하기 작업
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (myMap[i][j] < targetH) {
						block -= (targetH - myMap[i][j]); // 더한 만큼 인벤토리에서 제거
						// 더한 개수보다 갖고 있는 블록이 적으면 높이 다시 설정
						if(block < 0 ) {
							continue outer;
						}
						time += (targetH - myMap[i][j]); // 시간 계산
					}
				}
			} // 더하기 작업까지 종료
			
			if( time <= ansTime) {
				ansTime = time;
				ansHeight = targetH;
			}
		}// 높이 비교 종료
		
		System.out.println(ansTime+ " " + ansHeight);
	}
}
