package com.boj.day20220426;

import java.util.Scanner;

public class BOJ_11727_2Xn타일링2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n =sc.nextInt();
		
		int[] dp = new int[1001];
		
		dp[1]=1;
		dp[2]=3;
		
		for(int i=3;i<=n;i++) {
			//점화식으로 푸는 문제인데, 마지막 두 칸을 보면 된다.
			//1. 마지막 한 칸이 세로 줄 2개인 경우 dp[i-1]
			//2. 마지막 두 칸이 가로 줄인 경우. 요거는 두 가지 경우가 있슴다 낚이지 마세요잉
			dp[i]=(dp[i-1]+2*dp[i-2])%10007;
		}
		System.out.println(dp[n]);
		
	}
	
	
}
