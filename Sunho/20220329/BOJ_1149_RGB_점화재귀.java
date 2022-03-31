package com.boj.day20220329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1149_RGB_점화재귀 {

	static int[] cases= {0,1,2};
	//각각의 집의 페인트비용
	static int[][] Cost;
	//페인트 합 비용
	static int[][] DP;
	
	static int N=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		
		Cost=new int[N][3];
		DP=new int[N][3];
		
		for(int i=0;i<N;i++) {
			
			String[] str= br.readLine().split(" ");
			
			Cost[i][0]=Integer.parseInt(str[0]);
			Cost[i][1]=Integer.parseInt(str[1]);
			Cost[i][2]=Integer.parseInt(str[2]);
		}
		//초기화
		DP[0][0]=Cost[0][0];
		DP[0][1]=Cost[0][1];
		DP[0][2]=Cost[0][2];
		
		minCost(1);
		
		System.out.println(Math.min(Math.min(DP[N-1][0], DP[N-1][1]),  DP[N-1][2]));
		
	}
	
							//       
	public static void minCost(int count) {
		
		if(count==N) {
			return;
		}
		
		//점화식. 바로 전 항에서 다른 색 두가지의 최소값의 합에다가 이번 항을 더하는 형태!!
		DP[count][0]=Math.min(DP[count-1][1], DP[count-1][2])+Cost[count][0];
		DP[count][1]=Math.min(DP[count-1][2], DP[count-1][0])+Cost[count][1];
		DP[count][2]=Math.min(DP[count-1][0], DP[count-1][1])+Cost[count][2];
		
		minCost(count+1);
		
	}
}
