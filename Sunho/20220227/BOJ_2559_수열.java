package com.boj.day20220223;

import java.util.Scanner;

public class BOJ_2559_수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 전체 수열의 개수 
		int N = sc.nextInt();
		// 묶이는 날짜의 개수 
		int K = sc.nextInt();

		// 받아주는 배열
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int max=Integer.MIN_VALUE;   //그냥 무조건 이거 쓰자... 이거 때문에 몇번 틀렸니
		//          K개씩묶을 때 반복해야할 개수 
		for (int i = 0; i <= N - K ; i++) {
			int sum=0;
			for(int j=i;j<i+K;j++) {
				sum+=arr[j];
			}
			
			max=Math.max(max, sum);
			
		}
		
		System.out.println(max);

	}
}
