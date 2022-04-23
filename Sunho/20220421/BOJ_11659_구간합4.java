package com.boj.day20220421;

import java.util.Scanner;

public class BOJ_11659_구간합4 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		//미리 dp를 통해서 합을 구해두자
		long[] dp= new long[N+1];
		for(int i=1;i<dp.length;i++) {
			dp[i]=dp[i-1]+sc.nextLong();
		}
		
		StringBuilder sb = new StringBuilder();
		//어차피 연속된 부분을 더한 것이기 때문에, 맨 뒷부분의 값에서 앞부분 바로 전까지의 합을 빼면 구간합이 나온다
		for(int i=0;i<M;i++) {
			int st=sc.nextInt();
			int ed=sc.nextInt();
			
			long sum=dp[ed]-dp[st-1];
			
			
			sb.append(sum).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
		
	}
}