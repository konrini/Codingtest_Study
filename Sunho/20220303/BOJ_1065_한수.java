package com.boj.day20220303;

import java.util.Scanner;

public class BOJ_1065_한수 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		
		//문자열의 개수에 따라서 다르다.
		if((N+"").length()<=2) {
			
			System.out.println(N);
			
		}else {
			//어차피 두자리까지의 숫자는 다 등차수열이기 때문에 일단 더해주고 시작!
			int result=99;
			
			int[] arr=new int[3];
			
			
			int num=100;
			while(num<=N) {
				for(int i=0;i<3;i++) {
					
					arr[i]=(num+"").charAt(i)-'0';
					
				}
				
				
				if((arr[2]-arr[1])==(arr[1]-arr[0])) {
					result++;
				}
				
				num++;
			}
			
			System.out.println(result);
		}
	}
}
