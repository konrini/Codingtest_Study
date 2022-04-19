package com.boj.day20220412;

import java.util.Scanner;

public class BOJ_9095_더하기 {
	static int cnt;
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int tc=sc.nextInt();
		
		for(int index=0;index<tc;index++) {
			
			int num=sc.nextInt();
			cnt=0;
			check(num);
			
			System.out.println(cnt);
			
			
		}
		
		
	}

	private static void check(int num) {
		if(num<0) {
			return;
		}
		
		if(num==0) {
			cnt++;
			return;
		}
		
		check(num-1);
		check(num-2);
		check(num-3);
		
		
	}
}
