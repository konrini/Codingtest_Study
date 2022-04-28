package com.boj.day20220419;

import java.util.Scanner;

public class BOJ_2447_별찍기 {
	
	static String[][] arr;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		
		arr=new String[N][N];
		
		
		
		
		staring(0,0,N);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	

	
	
	private static void staring(int r,int c ,int num) {
		//3x3으로 끊자. 그래서 중간에 공백!
		if(num==3) {
			
			for(int i=r;i<r+3;i++) {
				for(int j=c;j<c+3;j++) {
					if(i==r+1 && j==c+1) {
						arr[i][j]=" ";
						continue;
					}
					arr[i][j]="*";
				}
			}
			
			
			return;
		}
		
		for(int i=r; i<r+num;i+=(num/3)) {
			for(int j=c; j<c+num;j+=(num/3)) {
				
				//중간에 공백 넣어주기
				if(i==r+(num/3) && j==c+(num/3)) {
					whiteCheck(i,j,(num/3));
					continue;
				}
				
				staring(i,j,num/3);
			}
		}
		
	}




	private static void whiteCheck(int r, int c, int num) {
		for(int i=r;i<r+num;i++) {
			for(int j=c;j<c+num;j++) {
				arr[i][j]=" ";
			}
		}
		
	}
	
	
	
}