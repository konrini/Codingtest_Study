package com.boj.day20220223;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2578_빙고 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr= new int[5][5];
		
		for(int i=0;i<5;i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0;j<5;j++) {
				arr[i][j]=Integer.parseInt(str[j]);
			}
		}
		
		//불러줄 숫자의 순서를 넣어주기 
		int[] count=new int[25];
		for(int i=0;i<5;i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0;j<5;j++) {
				count[5*i+j]=Integer.parseInt(str[j]);
			}
		}
		
		
		//25개를 하나씩 넣어보기
		for(int i=0;i<25;i++) {
			int num=count[i];
			

			//돌면서 해당하는 것을 찾아주기 

			for(int j=0;j<5;j++) {
				for(int k=0;k<5;k++) {
					if(arr[j][k]==num) {
						arr[j][k]=-1;
						break;
					}
				}
			}
			
//			if(i==11) {
//				System.out.println("row : "+row);
//				System.out.println("col : "+col);
//			}
//			
//			System.out.println(i+1+"번째");
//			for(int k=0;k<5;k++) {
//				for(int j=0;j<5;j++) {
//					System.out.print(arr[k][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("===============");
			//빙고개수 세기

			int cnt=0;

			//1.행 확인
			for(int j=0;j<5;j++) {
				boolean check=true;
				for(int k=0;k<5;k++) {
					if(arr[j][k]!=-1) {
						check=false;
						break;
					}
				}
				
				if(check) {
					cnt++;
				}
			}
			
			//2.열 확인
			for(int j=0;j<5;j++) {
				boolean check=true;
				for(int k=0;k<5;k++) {
					if(arr[k][j]!=-1) {
						check=false;
						break;
					}
				}
				
				if(check) {
					cnt++;
				}
			}
			
			//3.대각선 확인
			//3-1.하향대각선

			boolean check=true;
			for(int k=0;k<5;k++) {
				if(arr[k][4-k]!=-1) {
					check=false;
					break;
				}
			}
			
			if(check) {
				
				cnt++;
			}

			
			//3-2.상향대각선

			boolean check2=true;
			for(int k=0;k<5;k++) {
				if(arr[k][k]!=-1) {
					check2=false;
					break;
				}
			}
			
			if(check2) {
				cnt++;
			}


//		System.out.println(cnt+"개");
			
			if(cnt>=3) {
				System.out.println(i+1);
				return;
			}
			

		}
		
		
	}
	

}
