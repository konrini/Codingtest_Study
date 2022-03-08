package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2564 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());

		int W = Integer.parseInt(st1.nextToken());
		int H = Integer.parseInt(st1.nextToken());
		int storeCnt = Integer.parseInt(br.readLine());

		// 상점의 정보, 동근이 정보를 저장할 2차원 배열 생성
		int[][] info = new int[storeCnt + 1][2];

		StringTokenizer st;
		// 정보들 입력 받은 정보를 행,열 규칙에 맞게 바꿔서 저장
		// 북쪽이면 행은 0 다음 오는 수가 열
		// 서쪽이면 행은 다음오는수 열은 0
		// 남쪽이면 행은 H-1 다음오는 수가 열
		// 동쪽이면 행은 다음 오는 수, 열은 W-1
		for (int i = 0; i < storeCnt + 1; i++) {
			st = new StringTokenizer(br.readLine());
			switch (Integer.parseInt(st.nextToken())) {

			// 북쪽
			case 1:
				info[i][0] = 0;
				info[i][1] = Integer.parseInt(st.nextToken());
				break;
			// 남쪽
			case 2:
				info[i][0] = H ;
				info[i][1] = Integer.parseInt(st.nextToken());
				break;
			// 서쪽
			case 3:
				info[i][0] = Integer.parseInt(st.nextToken());
				info[i][1] = 0;
				break;
			// 동쪽
			case 4:
				info[i][0] = Integer.parseInt(st.nextToken());
				info[i][1] = W ;
				break;
			}
		}
		// 동근이와의 거리를 계산해서 짧은 거리를 더하기
		int ans = 0; // 최단거리의 합
		for (int i = 0; i < storeCnt; i++) {
			int temp = 0;
			int dist = 0;
			// info[storeCnt]는 동근이의 위치
			// 0, 1은 행과 열
			// 거리의 차가 H만크 나거나 W만큼 나면 반대쪽에 있는 경우이므로 다르게 계산해줘야함
			if(Math.abs(info[storeCnt][0] - info[i][0]) == H) { // 남, 북으로 있는 경우
				temp = info[storeCnt][1] + info[i][1] + H;
				
				// 시계방향, 반시계방향 중 짧은거 선택
				dist = temp < (H + W) * 2 - temp ? temp : (H + W) * 2 - temp;
			} else if(Math.abs(info[storeCnt][1] - info[i][1]) == W){ // 동, 서로 있는 경우
				temp = info[storeCnt][0] + info[i][0] + W;
				dist = temp < (H + W) * 2 - temp ? temp : (H + W) * 2 - temp;
			}
			else {
				temp = Math.abs(info[storeCnt][0] - info[i][0]) + Math.abs(info[storeCnt][1] - info[i][1]);
				dist = temp < (H + W) * 2 - temp ? temp : (H + W) * 2 - temp;
			}
			ans += dist;
		}
		System.out.println(ans);
	}
}
