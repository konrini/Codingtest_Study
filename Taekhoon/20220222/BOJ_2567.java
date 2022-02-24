package boj.class2;

import java.util.Scanner;

// 색종이를 붙였을때 검은 영역의 둘레...
public class BOJ_2567 {
	public static void main(String[] args) {
		// 색종이 하나 붙일때마다 40씩 증가
		// 겹치는 부분만큼 전체 합에서 빼주기
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 붙일 색종이의 개수

		int sum = 0; // 둘레의 합

		int[][] background = new int[100][100]; // 빈 도화지

		for (int cnt = 0; cnt < T; cnt++) {
			int left = sc.nextInt();
			int bottom = sc.nextInt();

			// 색종이의 크기만큼 돌면서 0이면 1로 1이라면 아무작업도 하지않는다.
			// 색종이들이 차지하는 면적을 1로, 아니면 0으로 표기함
			for (int i = bottom; i < bottom + 10; i++) {
				for (int j = left; j < left + 10; j++) {
					if (background[i][j] != 1) {
						background[i][j] = 1;
					}
				}
			} // 색종이들이 차지하는 면적 구하기 종료
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {

				// 색종이가 있는 곳이 경계인지 아닌지 확인
				
				if (background[i][j] == 1) {// 색종이의 위치에 1이 있을 때
					// 그 경계에 있는 0의 개수가 둘레가 됨.
					// 도화지의 경계에 놓여있는경우는 무조건 둘레에 해당함
					if (i == 0 || background[i - 1][j] == 0) {
						sum++;
					}
					if (i == 99||background[i + 1][j] == 0) {
						sum++;
					}
					if (j == 0||background[i][j - 1] == 0) {
						sum++;
					}
					if (j == 99 ||background[i][j + 1] == 0) {
						sum++;
					}

				}
			}
		}

		// 전체 둘레 출력
		System.out.println(sum);
	}
}
