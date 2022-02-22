package com.boj.day20220211;

import java.util.Scanner;

public class BOJ_1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num=sc.nextInt();
		
		int start=666;
		int cnt=0;
		int result=0;
		while(cnt<num) {
			
			if((start+"").contains("666")) {
				result=start;
				cnt++;
			}
			start++;
			
		}
		
		System.out.println(result);
	}
}
