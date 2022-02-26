package com.boj.day20220223;

import java.util.Scanner;

public class BOJ_2669_직사각형_네개의_합집합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr=new int[101][101];
		
		for(int i=0;i<4;i++) {
			
			int firstRow=sc.nextInt();
			int firstCol=sc.nextInt();
			int secondRow=sc.nextInt();
			int secondCol=sc.nextInt();
			
			for(int j=firstRow;j<secondRow;j++) {
				for(int k=firstCol;k<secondCol;k++) {
					if(arr[j][k]==0) {
						arr[j][k]=1;
					}
				}
			}
		}
		
		int cnt=0;
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				if(arr[i][j]==1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}