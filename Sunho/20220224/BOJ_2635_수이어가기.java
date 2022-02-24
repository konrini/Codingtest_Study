package com.boj.day20220223;

import java.util.Scanner;

public class BOJ_2635_수이어가기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num=sc.nextInt();
		
		//배열의 최대
		int max=0;
		int maxSecond=0;
		
		for(int i=1;i<=num;i++) {
			
			int first = num;
			int second=i;
			
			int count=2;
			while(first-second>=0) {
				count++;
				//first와 second를 바꾸기 위해서 잠시 넣어둘 변수로 선언 
				int temp1=first;
				int temp2=second;
				first=temp2;
				second=temp1-temp2;
			}
			
			if(max<count) {
				max=count;
				maxSecond=i;
			}
			
		}
		
		
		int[] arr= new int[max];
		arr[0]=num;
		arr[1]=maxSecond;
		for(int i=2;i<max;i++) {
			arr[i]=arr[i-2]-arr[i-1];
		}
		
		System.out.println(max);
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
		
	}
}

