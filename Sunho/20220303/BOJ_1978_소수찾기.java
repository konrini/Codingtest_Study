package com.boj.day20220303;

import java.util.Scanner;

public class BOJ_1978_소수찾기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N= sc.nextInt();
		
		int cnt=0;
		for(int idx=0;idx<N;idx++) {
			
			int num=sc.nextInt();
			if(num==1) {
				continue;
			}
			
			int result=0;
			for(int j=1;j<=Math.sqrt(num);j++) {
				
				
				if(num%j==0) {
					result++;
				}
				

				if(result>1) {
					break;
				}
				
			}
			
			
			
			if(result==1) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
		
	}
	
}

