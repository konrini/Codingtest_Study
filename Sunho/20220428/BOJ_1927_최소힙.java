package com.boj.day20220428;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1927_최소힙 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T =sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			
			int num=sc.nextInt();
			
			if(num==0) {
				
				if(pq.isEmpty()) {
					sb.append(0);
				}else {
					sb.append(pq.poll());
				}
				
				sb.append("\n");
			}else{
				pq.add(num);
			}
			
			
		}
		
		System.out.println(sb.toString());
		
	}
}
