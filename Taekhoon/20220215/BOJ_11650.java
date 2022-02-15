package boj.class2;

import java.util.Scanner;

public class Boj_11650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// x,y좌표를 저장하는 2차원 배열 생성
		int[][] cordi = new int[N][2];

		// 입력받은 값들을 cordi에 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				cordi[i][j] = sc.nextInt();
			}
		}
		cordi = countingSort(cordi);
		for (int i = 0; i < N; i++) {
			System.out.println(cordi[i][0] + " " + cordi[i][1]);
		}

	} // main함수 종료

	public static int[][] countingSort(int[][] arr) {
		// 배열을 정렬해보자

		int N = arr.length; // 배열의 크기
		int K = Integer.MIN_VALUE; // 데이터의 최댓값

		// y좌표 기준으로 먼저..
		int min_y = Integer.MAX_VALUE;
		// 최솟값이 음수인지 확인하고 음수면 그 값이 0이 되도록 shift
		for (int i = 0; i < N; i++) {
			if (arr[i][1] < min_y)
				min_y = arr[i][1];
		}

		if (min_y < 0) {
			for (int i = 0; i < N; i++) {
				arr[i][1] -= min_y;
			}
		} // 음수값 shifting 종료

		// 최댓값 찾기
		for (int i = 0; i < N; i++) {
			if (arr[i][1] > K)
				K = arr[i][1];
		} // 최댓값 찾기 종료

		// 배열의 값의 개수를 저장하는 배열 (K+1의 길이를 갖도록해야함)
		int[] count = new int[K + 1];

		// 정렬된 배열을 저장하는 배열

		int[][] sorted = new int[N][2];
		// 카운팅 시작
		for (int i = 0; i < N; i++) {
			count[arr[i][1]]++;
		}

		// 누적합 구하기
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		// 정렬시작
		for (int i = N - 1; i >= 0; i--) {
			sorted[--count[arr[i][1]]] = arr[i];
		}
		// 정렬이 다 종료된 후에 쉬프팅이 있었으면 다시 원상복구시켜줌
		if (min_y < 0) {
			for (int i = 0; i < N; i++) {
				arr[i][1] += min_y;
			}
		}

		arr = sorted;

		// x좌표 기준으로 한 번 더..
		int min_x = Integer.MAX_VALUE;
		// 최솟값이 음수인지 확인하고 음수면 그 값이 0이 되도록 shift
		for (int i = 0; i < N; i++) {
			if (arr[i][0] < min_x)
				min_x = arr[i][0];
		}

		if (min_x < 0) {
			for (int i = 0; i < N; i++) {
				arr[i][0] -= min_x;
			}
		} // 음수값 shifting 종료

		// 최댓값 찾기
		for (int i = 0; i < N; i++) {
			if (arr[i][0] > K)
				K = arr[i][0];
		} // 최댓값 찾기 종료

		// 배열의 값의 개수를 저장하는 배열 (K+1의 길이를 갖도록해야함)
		int[] count2 = new int[K + 1];

		// 정렬된 배열을 저장하는 배열

		int[][] sorted2 = new int[N][2];
		// 카운팅 시작
		for (int i = 0; i < N; i++) {
			count2[arr[i][0]]++;
		}

		// 누적합 구하기
		for (int i = 1; i < count2.length; i++) {
			count2[i] += count2[i - 1];
		}

		// 정렬시작
		for (int i = N - 1; i >= 0; i--) {
			sorted2[--count2[arr[i][0]]] = arr[i];
		}

		// 정렬이 다 종료된 후에 쉬프팅이 있었으면 다시 원상복구시켜줌
		if (min_x < 0) {
			for (int i = 0; i < N; i++) {
				arr[i][0] += min_x;
			}
		}

		return sorted2;

	}
}
