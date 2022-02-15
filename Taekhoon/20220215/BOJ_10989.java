package boj.class2;

import java.util.Scanner;

public class Boj_10989 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 배열을 정렬해보자
		int cnt = sc.nextInt();
		int[] arr = new int[cnt];
		for(int i = 0; i < cnt; i++) {
			arr[i] = sc.nextInt();
		}

		int N = arr.length; // 배열의 크기
		int K = -1; // 데이터의 최댓값

		// 최댓값 찾기
		for (int i = 0; i < N; i++) {
			if( arr[i] >K ) K = arr[i];
		} // 최댓값 찾기 종료

		// 배열의 값의 개수를 저장하는 배열 (K+1의 길이를 갖도록해야함)
		int[] count = new int[K + 1];

		// 정렬된 배열을 저장하는 배열
		
		int[] sorted = new int[N];
		// 카운팅 시작
		for (int i = 0; i < N; i++) {
			count[arr[i]]++;
		}

		// 누적합 구하기
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		// 정렬시작
		for(int i = N-1; i >=0; i--) {
//			int arrIdx = arr[i];
//			int sortedIdx = count[arrIdx]-1;
//			
//			sorted[sortedIdx] = arr[i];
			
			sorted[--count[arr[i]]] = arr[i];
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println(sorted[i]);
		}
	}
}
