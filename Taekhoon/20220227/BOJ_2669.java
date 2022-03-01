package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2669 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] back = new int[101][101];
		int ans = 0;
		for (int sq = 1; sq <= 4; sq++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
//			i<r2, j <c2에서 등호가 빠진이유
//			시작지점부터 1*1짜리 그린다고 생각
			for (int i = r1; i < r2; i++) {
				for (int j = c1; j < c2; j++) {
					back[i][j]++;
				}
			}
		}
		for (int i = 0; i < back.length; i++) {
			for (int j = 0; j < back.length; j++) {
				if (back[i][j] > 0) {
					ans++;
				}
			}
		}

		System.out.println(ans);
	}
}
