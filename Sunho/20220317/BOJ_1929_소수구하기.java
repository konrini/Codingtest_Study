package com.boj.day20220317;

import java.util.Scanner;

public class BOJ_1929_소수구하기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		for(int i=N;i<=M;i++) {
			
			if(i==1) {
				continue;
			}
			
			Boolean check=true;
			for(int j=2;j<=Math.sqrt(i);j++) {
				
				if(i%j==0) {
					check=false;
					break;
				}
				
				
			}
			
			if(check) {
				System.out.println(i);
			}
			
		}
		
	}
}