package boj.class2;

import java.util.Scanner;

public class BOJ_2578 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 5;
		int[][] bingo = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bingo[i][j] = sc.nextInt();
			}
		}

		int cnt = 0; // 사회자가 번호를 부른 횟수
		int lines = 0; // 빙고가 완성된 줄의 개수
		// 빙고 줄이 3이 될 때까지 반복
		while (lines < 3) {
			int call = sc.nextInt(); // 사회자가 부른 번호
			cnt++;

			// 사회자가 부른 번호의 인덱스
			int r = -1; // 행
			int c = -1; // 열
			// 그 번호가 몇 번 인덱스에 있는지 부터 찾자
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (call == bingo[i][j]) {
						r = i;
						c = j;
					}
				}
			} // 빙고판에서 사회자가 부른 번호의 인덱스까지 찾기 완료
				// 불린 번호 0으로 바꾸기
			bingo[r][c] = 0;

			// 그 인덱스에서 가로빙고, 세로빙고, 대각선빙고가 있는지를 확인하자.
			lines += horizontal(bingo, r, c) + vertical(bingo, r, c) + diagonal1(bingo, r, c)+diagonal2(bingo, r, c);
			

		} // while문 종료

		System.out.println(cnt);
	} // main종료

	public static int horizontal(int[][] arr, int row, int col) {
		int zero = 0;

		for (int m = -4; m <= 4; m++) {
			int nc = col + m;
			if (nc >= 0 && nc < 5) {
				if (arr[row][nc] == 0) {
					zero++;
				}
			}
		}
		if (zero == 5)
			return 1;
		else
			return 0;
	}

	public static int vertical(int[][] arr, int row, int col) {
		int zero = 0;
		for (int m = -4; m <= 4; m++) {
			int nr = row + m;
			if (nr >= 0 && nr < 5) {
				if (arr[nr][col] == 0) {
					zero++;
				}
			}
		}
		if (zero == 5)
			return 1;
		else
			return 0;
	}

	public static int diagonal1(int[][] arr, int row, int col) {
		// 오른쪽위방향
		int zero = 0;
		for (int m = -4; m <= 4; m++) {
			int nr = row - m;
			int nc = col + m;
			if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5) {
				if (arr[nr][nc] == 0) {
					zero++;
				}
			}
		}
		if (zero == 5)
			return 1;
		else
			return 0;
	}

	public static int diagonal2(int[][] arr, int row, int col) {
		// 오른쪽 아래 방향
		int zero = 0;
		for (int m = -4; m <= 4; m++) {
			int nr = row + m;
			int nc = col + m;
			if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5) {
				if (arr[nr][nc] == 0) {
					zero++;
				}
			}
		}
		if (zero == 5)
			return 1;
		else
			return 0;
	}
}
