package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {

	static int[][] field; // 배추밭
	static int M; // 가로길이
	static int N; // 세로 길이
	static int K; // 배추의 개수

	// 4방 탐색
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 배추밭 가로 길이
			N = Integer.parseInt(st.nextToken()); // 배추밭 세로 길이
			K = Integer.parseInt(st.nextToken());

			// 배추밭 초기화
			field = new int[N][M]; // 행에 세로길이,, 열에 가로길이,,
			// 배추위치 1로 바꾸기
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				// 배추위치의 열
				int c = Integer.parseInt(st.nextToken());
				// 배추 위치의 행
				int r = Integer.parseInt(st.nextToken());
				field[r][c] = 1;
			}
			int cnt = 0; // 배추벌레의 마리 수

			// 2차원 배열 탐색하면서 배추가 발견되면 dfs돌리고 배추벌레 카운트 1증가
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (field[i][j] == 1) {
						++cnt;
						dfs(i, j);
					}
				}
			} // 배추벌레 배치 완료

			// 필요한 최소 배추벌레 출력
			System.out.println(cnt);
		} // tc
	} // main

	public static void dfs(int r, int c) {
		// 방문처리
		field[r][c] = 0;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (0 <= nr && nr < N && 0 <= nc && nc < M && field[nr][nc] == 1) {
				field[nr][nc] = 0;
				dfs(nr, nc);
			}
		}
	}
}
