package com.boj.day20220303;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1920_수찾기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		

		
		int M=sc.nextInt();
		
		
		//이진정렬 써보자!
		for(int i=0;i<M;i++) {
			int find=sc.nextInt();
			
			int st=0;
			int ed=arr.length-1;
			
			while(true) {
				
				int mid=(st+ed)/2;
				
				if(arr[mid]==find) {
					System.out.println(1);
					break;
				}else if(arr[mid]<find) {
					st=mid+1;
				}else {
					ed=mid-1;
				}
				
				//종료 조건 넣어주기
				if(st>ed) {
					System.out.println(0);
					break;
				}
				
			}
			
			
		}
		
		
	}
}

