package com.boj.day20220426;

import java.util.Scanner;

public class BOJ_1012_유기농배추 {
	
	static int[][] arr;
	
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static int idx,M,N;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T= sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			
			M=sc.nextInt();
			N=sc.nextInt();
			int K=sc.nextInt();
			
			arr=new int[M][N];
			
			//인덱스의 숫자를 통해서 무더기를 하나씩 넘버링한다. 즉, 덩어리는 같은 숫자로 표기하도록 하자.
			idx=2;
			for(int i=0;i<K;i++) {
				int r=sc.nextInt();
				int c=sc.nextInt();
				
				arr[r][c]=1;
				
			}
			
			//서로소 집합으로 가볼까 고민중이다.- 12시 16분 
			//비스므리하게 가볼꺼다. 막지마라 - 12시 20분
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					
					if(arr[i][j]==1) {
						marking(i,j);
						idx++;
					}
					
					
				}
			}
			
			System.out.println(idx-2);
			
			
			
			
		}
	}
	private static void marking(int r, int c) {
		//						어차피 1이 아니면 못가거나, 이미 간 곳. 즉 방문처리로 사용 가능 
		if(r<0||r>=M||c<0||c>=N||arr[r][c]!=1) {
			return;
		}
		
		
		//인덱스로 처리해버리자. 그래서 arr에 숫자가 같은 것들로 뒤덮이도록 진행한다.
		arr[r][c]=idx;
		
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			marking(nr,nc);
		}
		
	}
}