package com.boj.day20220407;

import java.util.Scanner;

public class BOJ_1003_피보나치 {
	//			0     1
	static int zCnt,oCnt;
//	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		
		int[][] arr = new int[41][2];
		
		//기본으로 넣어주기 
		//0일 때 
		arr[0][0]=1;
		//1일 때 
		arr[1][1]=1;
		
		
		//핵심 아이디어는 i-1번째 항의 1,0의 개수와 i-2번째 항의 1,0의 개수를 각각 더하면 i번재 항의 1,0의 개수가 나온다는 것이다. 그래서 필요한만큼 만들어두고 시작하는 게 낫다.
		//문제에서 40까지만 줬기 때문에 40까지만 처리한다.
		for(int i=2;i<=40;i++) {
			arr[i][0]=arr[i-1][0]+arr[i-2][0];
			arr[i][1]=arr[i-1][1]+arr[i-2][1];
		}
		
		
		for(int index=0;index<n;index++) {
			
			int num=sc.nextInt();
			
//			fibo(num);
			
			System.out.printf("%d %d\n",arr[num][0],arr[num][1]);
			

			
		}
	}
//	private static int fibo(int num) {
//		if(num==0) {
//			zCnt++;
//			return 0;
//			
//		}else if(num==1) {
//			oCnt++;
//			return 1;
//		}else {
//			return fibo(num-1)+fibo(num-2);
//		}
//		
//	}
}