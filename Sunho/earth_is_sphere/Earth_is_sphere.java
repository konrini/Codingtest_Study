package com.boj.day20220530;

import java.util.Scanner;

public class Earth_is_sphere {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int tc=0;tc<T;tc++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			
			int[][] points=new int[M+1][2];
			
			int[][] arr = new int[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j]=sc.nextInt();
					
					//좌표 찍기
					if(arr[i][j]>0) {
						points[arr[i][j]][0]=i;
						points[arr[i][j]][1]=j;
					}
				}
			}
			//확장 십자가 만들기			
			int stIdx=1;
			int stR=N;
			int stC=N;
			
			int result=0;
			
			int[] dr= {0,0,0,N,N,N,2*N,2*N,2*N};
			int[] dc= {0,N,2*N,0,N,2*N,0,N,2*N};
			
			while(stIdx<=M) {
				int nextR=points[stIdx][0];
				int nextC=points[stIdx][1];
				int min=2*N;
				
				for(int i=0;i<9;i++) {
					
					int targetR=nextR+dr[i];
					int targetC=nextC+dc[i];
					
					int distance=Math.abs(stR-targetR)+Math.abs(stC-targetC);
					min=Math.min(min, distance);
					
				}
				
				result+=min;
				
				//다음꺼 준비
				stR=nextR+N;
				stC=nextC+N;
				stIdx++;
				
			}
			
			System.out.printf("#%d %d\n",tc+1,result);
		}
		
	}
}
