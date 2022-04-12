package com.boj.day20220412;

import java.util.Scanner;

public class BOJ_1463_1로만들기 {
	
	static int min;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		
		min=Integer.MAX_VALUE;
		
		check(n,0);
		
		System.out.println(min);
		
	}
	
	//어떤 순서로 해야 최소값이 될지 모르기 때문에, 일단 재귀함수로 돌리자 
	public static void check(int n, int cnt) {
		//이미 min넘어가면 끝이다
		if(cnt>min) {
			return;
		}
		
		//1로 만들어지면 확인하기
		if(n==1) {
			min=Math.min(min, cnt);
			return;
		}
		
		//3가지 경우 전부 체크하기
		if(n%3==0) {
			check(n/3,cnt+1);
		}
		
		if(n%2==0) {
			check(n/2,cnt+1);
		}
		
		check(n-1,cnt+1);
		
		
	}
}