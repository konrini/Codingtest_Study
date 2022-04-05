package com.boj.day20220330;

import java.util.Scanner;

public class BOj_11053_가장긴증가하는부분수열 {
	static int[] arr;
	static int[] dp;
	static int result=0;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		arr= new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		//점화식으로 풀어보자.
		//아래는 길이의 최대값을 뒤에서부터 넣는 방법!
		dp = new int[N];
		
		counting(N-1);
		
		System.out.println(result);
		
		
		
	}
	
	public static void counting(int idx) {
		//종료부 
		if(idx<0) {
			return;
		}
		
		
		//재귀부 
		int max=0;
		for(int i=idx+1;i<N;i++) {
			if(arr[idx]<arr[i]) {
				max=Math.max(max, dp[i]);
			}
		}
		
		dp[idx]=max+1;
		
		result=Math.max(result, dp[idx]);
		
		counting(idx-1);
		
	}
}