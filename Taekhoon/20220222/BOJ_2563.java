package boj.class2;

import java.util.Scanner;

// 가로, 세로 10짜리 색종이
// 왼쪽변과 도화지왼쪽변 거리, 색종이 아래쪽변과 도화지 아래쪽변과의 거리
// 색종이가 도화지 밖으로 나가는 경우 없음

public class BOJ_2563 {
	public static void main(String[] args) {
		// 100 * 100 이차원 배열 만들고
		// 각 색종이가 차지하는 만큼 1로 만듦
		// 만약 거기가 이미 1로 되어있으면 pass
		// 마지막 전체 summation

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 색종이의 수

		// 빈도화지 생성
		int[][] background = new int[100][100];

		// 입력받는 색종이의 왼쪽변, 아래변까지거리를 이용해 왼쪽위 오른쪽 아래 좌표를 구한다.
		for (int cnt = 0; cnt < T; cnt++) {
			int left = sc.nextInt();
			int bottom = sc.nextInt();
			
			// 색종이의 크기만큼 돌면서 0이면 1로 1이라면 아무작업도 하지않는다.
			for (int i = bottom; i < bottom + 10; i++) {
				for (int j = left; j < left + 10; j++) {
					if (background[i][j] != 1) {
						background[i][j] = 1;
					}
				}
			}// 색종이 전체 면적 구하기 종료
		}
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				sum += background[i][j];
			}
		}
		System.out.println(sum);
	}
}
