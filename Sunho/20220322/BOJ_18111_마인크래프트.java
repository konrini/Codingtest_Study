package com.boj.day20220322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_18111_마인크래프트 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s1=br.readLine().split(" ");
		int N=Integer.parseInt(s1[0]);
		int M=Integer.parseInt(s1[1]);
		int B=Integer.parseInt(s1[2]);
		
		int[][] arr = new int[N][M];
		
		int min=Integer.MAX_VALUE;
		
		int sum=0;
		
		for(int i=0;i<N;i++) {
			String[] s=br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				
				
				arr[i][j]=Integer.parseInt(s[j]);
				sum+=arr[i][j];
				
				
				if(arr[i][j]<min) {
					min=arr[i][j];
				}
			}
		}
		
		//하나당  들어갈 수 있는 최대의 박스 개수 
		int max=(sum+B)/(N*M);
		
		//최단시간 
		int result=Integer.MAX_VALUE;
		//그 때의 개수 
		int resultCnt=0;
		
		for(int cnt=min;cnt<=max;cnt++) {
			//걸린 시간 
			int second=0;
			
			//먼저 박스부터 회수
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					//차이만큼 회수. 하나당 2초 
					if(arr[i][j]>cnt) {
						int dif=arr[i][j]-cnt;
						
						second+=2*dif;
						
					}
					
					//넣어주기 하나당 1초 
					if(arr[i][j]<cnt) {
						int dif=cnt-arr[i][j];
						
						second+=dif;
						
					}
					
				}
			}
			
			
			
			
			if(result>=second) {
				
				result=second;
				resultCnt=cnt;
			}
		}
		
		System.out.println(result+" "+resultCnt);
		
		
		
	}
}
