package boj.class3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11399_ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		// 대기 시간 입력 받기
		for(int i =0;i < N;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr); // 오름차순으로 정렬
		
		
		// 각 사람이 기다려야하는 시간 배열
		int[] sumArr = new int[N];
		int ans = 0;
		
		// 0번째는 0번사람의 시간만큼만 소요
		sumArr[0] = arr[0];
		// 정답에 0번째 추가
		ans += sumArr[0];
		
		// 1부터 N-1까지 돌면서 그전까지의 소요시간에 해당 차례에 소요되는 시간 더하고
		// 그 값을 ans에 저장
		for(int i = 1;i <N;i++) {
			sumArr[i] = sumArr[i-1] + arr[i];
			ans += sumArr[i];
		}
		System.out.println(ans);
		
	}
}
