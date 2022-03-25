package com.boj.day20220322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2805_나무자르기 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str1= br.readLine().split(" ");
		
		int N=Integer.parseInt(str1[0]);
		int M=Integer.parseInt(str1[1]);
	
		
		int[] arr = new int[N];
		
		int max=0;
		
		String[] str2=br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			
			int num=Integer.parseInt(str2[i]);
			
			max=Math.max(max, num);
			
			arr[i]=num;
		}
		
		int st=0;
		int ed=max;
		
		
		
		while(st<ed) {
			int mid=(st+ed)/2;
//			System.out.println("st : "+st);
//			System.out.println("ed : "+ed);
//			System.out.println(mid);
			
			long sum=0;
			for(int i=0;i<N;i++) {
				
				if(arr[i]>mid) {
					sum+=(arr[i]-mid);
				}
			}
			
			if(sum>=M) {
				st=mid+1;
			}else {
				ed=mid;
			}
			
			
		}
		
		System.out.println(st-1);
	}
}