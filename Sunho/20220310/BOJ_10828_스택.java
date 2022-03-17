package com.boj.day20220310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10828_스택 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int idx=0;idx<t;idx++) {
			
			String[] strArr = br.readLine().split(" ");
			
			
			
			
			if(strArr.length==1) {
				
				String str = strArr[0];
				
				switch(str) {
				//top은 위에꺼만 확인.
				case "top": 
					
					if(stack.isEmpty()) {
						System.out.println(-1);
					}else {
						System.out.println(stack.peek()); 
					}
					
					
					break;
				case "size": 
					
					System.out.println(stack.size());
					
					break;
				case "empty": 
					if(stack.isEmpty()) {
						System.out.println(1);
					}else {
						System.out.println(0);
					}
					
					break;
				case "pop":
					if(stack.isEmpty()) {
						System.out.println(-1);
					}else {
						System.out.println(stack.pop()); 
					}
					
					break;
				}
				
			//push 밖에 없다!	
			}else if(strArr.length==2){
				int num=Integer.parseInt(strArr[1]);
				
				stack.push(num);
				
				
			}
			
			
			
			
			
		}
		
	}
}