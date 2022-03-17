package com.boj.day20220315;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11866_요세푸스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> que = new LinkedList<>();
		
		int N= sc.nextInt();
		
		for(int i=1;i<=N;i++) {
			que.add(i);
		}
		
		int[] arr = new int[N];
		int index=0;
		
		int M=sc.nextInt();
		int cnt=1;
		while(que.size()>1) {
			
			int num=que.poll();
			
			if(cnt==M) {
				
				arr[index]=num;
				index++;
				
				cnt=1;
				continue;
				
			}else {
				
				que.add(num);
				cnt++;
				
			}
		}
		
		arr[N-1]=que.poll();
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i=0;i<N-1;i++) {
			sb.append(arr[i]+", ");
		}
		sb.append(arr[N-1]+">");
		
		System.out.println(sb.toString());
		
		
		
	}
}