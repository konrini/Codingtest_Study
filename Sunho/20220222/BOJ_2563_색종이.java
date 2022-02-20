package com.boj.day20220218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2563_색종이 {
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
		
		
		int[][] surface=new int[100][100];
		
		//surface는 0으로 초기화되어있는데, 검은색이면 1로 다 바꿔주기로 한다. 
		for(int i=0;i<arr.length;i++) {
			int x=arr[i][0];
			int y=arr[i][1];
			
			surface=changeBlack(surface, x, y);
			
			
		}
		
		int cnt =0;
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(surface[i][j]==1) {
					cnt++;
				}
			}
			
		}
		
		System.out.println(cnt);
		
		
	}
	
	public static int[][] changeBlack(int[][] arr, int x,int y){
		
		
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				
				arr[y+i][x+j]=1;
				
				
			}
		}
		
		
		return arr;
	}
}
