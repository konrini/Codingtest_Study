package com.boj.day20220220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2567_색종이2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[num][2];
		
		for(int i=0;i<num;i++) {
			String[] a = br.readLine().split(" ");
			
			//x좌표
			arr[i][0]=Integer.parseInt(a[0]);
			//y좌표
			arr[i][1]=Integer.parseInt(a[1]);
			
		
				
		}
		
		
		int[][] surface=new int[101][101];
		
		//surface는 0으로 초기화되어있는데, 검은색이면 1로 다 바꿔주기로 한다. 
		for(int i=0;i<arr.length;i++) {
			int x=arr[i][0];
			int y=arr[i][1];
			
			surface=changeBlack(surface, x, y);
		}
		
		int cnt=0;
		
		//여기서 내부에 있는 것들은 상하좌우가 전부 1이다. 그렇기 때문에 지금부터 상하좌우를 비교해서 1이 아닌 것
		for(int i=0;i<=100;i++) {
			for(int j=0;j<=100;j++) {
				
				if(surface[i][j]==1&&(i==0||i==100||j==0||j==100)) {
					cnt++;
					continue;
				}
				
				
				
				if(surface[i][j]==1) {
					
					if(surface[i-1][j]==0) {
						cnt++;
					}
					if(surface[i+1][j]==0) {
						cnt++;				
					}
					if(surface[i][j-1]==0) {
						cnt++;
					}
					if(surface[i][j+1]==0) {
						cnt++;
					}
					
				}
			}
		}
		
		System.out.println(cnt);
		
	}
	
	public static int[][] changeBlack(int[][] arr, int x,int y){
		
		
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				
				arr[x+i][y+j]=1;
				
				
			}
		}
		
		
		return arr;
	}
	

}
