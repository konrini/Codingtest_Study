package com.boj.day20220310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_10866_덱 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		Deque<Integer> deq = new ArrayDeque<Integer>();
		
		
		for(int idx=0;idx<t;idx++) {
			
			String[] strArr = br.readLine().split(" ");
			
			
			
			
			if(strArr.length==1) {
				
				String str = strArr[0];
				
				switch(str) {
				
				case "pop_front": 
					if(deq.isEmpty()) {
						System.out.println(-1);
					}else {
						System.out.println(deq.poll());
					}
					
					
					break;
				
				case "pop_back": 
					if(deq.isEmpty()) {
						System.out.println(-1);
					}else {
						System.out.println(deq.pollLast());
					}
					break;
				
				case "size":
					System.out.println(deq.size());
					break;
				
				case "empty":
					if(deq.isEmpty()) {
						System.out.println(1);
					}else {
						System.out.println(0);
					}
					
					break;
				
				case "front": 
					
					if(deq.isEmpty()) {
						System.out.println(-1);
					}else {
						System.out.println(deq.peekFirst());
					}
					
					break;
				
				case "back": 
					
					if(deq.isEmpty()) {
						System.out.println(-1);
					}else {
						System.out.println(deq.peekLast());
					}
					
					break;
				
				
				}
				
			//push 밖에 없다!	
				
			}else if(strArr.length==2){
				
				String str = strArr[0];
				int num=Integer.parseInt(strArr[1]);
				
				if(str.equals("push_front")) {
					
					deq.addFirst(num);
					
				}else {
					deq.addLast(num);
				}
				
			}
			
		}
	}
}