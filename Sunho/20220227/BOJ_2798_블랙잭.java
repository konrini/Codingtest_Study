package com.boj.day20220223;

import java.util.Scanner;

public class BOJ_2798_블랙잭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num=sc.nextInt();
		int black=sc.nextInt();
		
		int[] arr = new int[num];
		
		for(int i=0;i<num;i++) {
			arr[i]=sc.nextInt();
		}
		
		int max=0;
		
		for(int i=0;i<arr.length-2;i++) {
			for(int j=i+1;j<arr.length-1;j++) {
				for(int k=j+1;k<arr.length;k++) {
					
					if((arr[i]>=black)||(arr[j]>=black)||(arr[k]>=black)) {
						continue;
					}
					
					int sum=arr[i]+arr[j]+arr[k];
					
					if((sum<=black)&&(sum>max)) {
						max=sum;
					}
					
				}
			}
			
		}
		
		System.out.println(max);
		
	}
}
