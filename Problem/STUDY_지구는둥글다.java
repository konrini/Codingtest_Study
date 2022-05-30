package STUDY_220530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class STUDY_지구는둥글다 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// testCase 개수 구하기
		int testCase = Integer.parseInt(br.readLine());
		// N 배열 크기
		for (int t = 1; t <= testCase; t++) {
			int N = Integer.parseInt(br.readLine());
			// M 나라 개수
			int M = Integer.parseInt(br.readLine());
			// 지도
			int[][] map = new int[N][N];
			// 앞으로 가야할 좌표
			int[][] coordinate = new int[M + 1][2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 1, 2, 3, 4 
					if (map[i][j] != 0)
						coordinate[map[i][j]] = new int[] { i, j };

				}
			} // end for : 입력 완료(지도, 가야할 행,열 좌표)
			int ans = 0;

			for (int i = 0; i < M; i++) {
				int[] now = coordinate[i];
				int[] next = coordinate[i + 1];
				int absRow = Math.abs(next[0] - now[0]);
				int absCol = Math.abs(next[1] - now[1]);
				int distRow = Math.min(absRow, N - absRow); // 0,0, 0,3 N = 5,
				int distCol = Math.min(absCol, N - absCol); //  5-(3-0), 3-0, => 3, 2
				ans += distRow;
				ans += distCol;
			}
			System.out.println("#" + t + " " +  ans);
		}

	}
}
