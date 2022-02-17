package boj.class2;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1018 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 입력받을 체스판의 행의 개수
		int M = sc.nextInt(); // 입력받을 체스판의 열을 개수
//		System.out.println("N,M 입력 완료");
//		System.out.printf("N: %d, M: %d\n", N, M);

		// 입력받을 체스판 2차원 배열(N * M)
		char[][] chessMap = new char[N][M];

		// 한 행씩 입력 받음
		for (int i = 0; i < N; i++) {
			String row = sc.next();
			for (int j = 0; j < M; j++) {
				chessMap[i][j] = row.charAt(j);
			}

		} // 체스판 입력 종료
//		System.out.println("체스판 입력 완료");

		// B는 0으로, W는 1로 바꿔줌
		int[][] intChessMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				intChessMap[i][j] = (chessMap[i][j] == 'B') ? 0 : 1;
			}
//			System.out.println(Arrays.toString(intChessMap[i]));
		}
//		System.out.println();

		// 2종류의 정상 체스판 생성; 2차원 배열(8 * 8)
		// normalMapB는 왼쪽위가 검은색으로 시작하는 체스판
		// normalMapW는 왼쪽위가 흰색으로 시작하는 체스판
		int[][] normalMapB = new int[8][8];
		int[][] normalMapW = new int[8][8];

		// 0과 1을 번갈아 입력해주기 위한 변수
		int a = 0;

		for (int i = 0; i < 8; i++) {
			a = (a == 1) ? 0 : 1;
			for (int j = 0; j < 8; j++) {
				normalMapB[i][j] = 1 - a;
				a = (a == 1) ? 0 : 1;
			}
//			System.out.println(Arrays.toString(normalMapB[i]));
		} // 왼쪽위가 검은색인 체스판 생성 종료

		// 0과 1을 번갈아 입력해주기 위한 변수
		a = 1;

		for (int i = 0; i < 8; i++) {
			a = (a == 1) ? 0 : 1;
			for (int j = 0; j < 8; j++) {
				normalMapW[i][j] = 1 - a;
				a = (a == 1) ? 0 : 1;
			}
//			System.out.println(Arrays.toString(normalMapW[i]));
		} // 왼쪽위가 흰색인 체스판 생성 종료


		// 입력받은 체스판(chessMap)의 시작점을 잡아서 흰색정상체스판, 검은색정상체스판과
		// 비교해서 각각 바꿔야할 타일의 개수를 센다.

		int minCnt = 64; // 최솟값을 찾아야하므로 64로 변수 설정

		// 검은색 체스판과 비교
		// (r,c)는 비교할 체스판의 시작 위치
		for (int r = 0; r < N - 7; r++) {
			for (int c = 0; c < M - 7; c++) {
				// 각 시작 위치마다 정상체스판과 비교
				int cnt = 0; // 바꿔야할 타일의 개수;
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (intChessMap[r + i][c + j] != normalMapB[i][j]) {
							cnt++;
						}

					}
				} // r,c에서 normalMapB와 비교 종료

				if (cnt < minCnt) {
					minCnt = cnt;
				}
			}
		} // r,c 설정 종료

		// 흰색 체스판과 비교
		for (int r = 0; r < N - 7; r++) {
			for (int c = 0; c < M - 7; c++) {
				// 각 시작 위치마다 정상체스판과 비교
				int cnt = 0; // 바꿔야할 타일의 개수;
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (intChessMap[r + i][c + j] != normalMapW[i][j]) {
							cnt++;
						}

					}
				} // r,c에서 normalMapW와 비교 종료

				if (cnt < minCnt) {
					minCnt = cnt;
				}
			}
		} // r,c 설정 종료

		System.out.println(minCnt);

	}
}
