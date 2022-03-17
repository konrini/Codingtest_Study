package com.boj.day20220315;

import java.util.Scanner;

public class BOJ_1654_랜선자르기2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int K=sc.nextInt();
		int N=sc.nextInt();
		
		//값 넣기 방법
		long[] arr = new long[K];
		
		long max=0;
		
		for(int i=0;i<K;i++) {
			
			arr[i]=sc.nextLong();
			
			if(max<arr[i]) {
				max=arr[i];
			}
			
		}
		
		long st=1;
		long ed=max;
		
//		int middle=0;
		
		long result=0;
		
		
		while(st<=ed) {
			
			
			
			long mid=(st+ed)/2;
			int cnt=0;
			
			
			
			for(int i=0;i<K;i++) {
				
				long quo=arr[i]/mid;
//				if(quo==0) {
//					quo=1;
//				}
				
				cnt+=quo;
			}
			
			if(cnt<N) {
				ed=mid-1;
			}else if(cnt>=N) {
				result=Math.max(result, mid);
				st=mid+1;
			}
			
			
		}
		
		//N토막이 나는 경우를 처음 찾았다. 그러면 여기서 가장 큰 값을 찾아나가야 한다.
//		
//		while(middle<=ed) {
//			
//			
//			
//			int mid = (middle+ed)/2;
//			
//			
//			if(middle==ed || middle==ed-1) {
//				result=mid;
//			}
//			
//			
//			int cnt=0;
//			for(int i=0;i<K;i++) {
//				
//				int quo=arr[i]/mid;
//				if(quo==0) {
//					quo=1;
//				}
//				
//				cnt+=quo;
//			}
//			
//			if(cnt!=mid) {
//				ed=mid-1;
//			}else {
//				middle=mid;
//			}
//			
//		}
		//위의 주석은 너무 많이 생각했다. 그냥 끝까지 돌면서 원하는 결과를 뽑아내는 형태면 된다......
		
		
		
		System.out.println(result);
		
		
	}
}
