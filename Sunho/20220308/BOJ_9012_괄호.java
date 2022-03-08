package com.boj.day20220308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012_괄호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		outer:
		for(int idx=0;idx<t;idx++) {
			
			String str = br.readLine();
			
			Stack<Character> stack = new Stack<>();
			
			for(int i=0;i<str.length();i++) {
				
				char c = str.charAt(i);
				
				if(c=='(') {
					stack.push(c);
				}else {
					
					if(stack.isEmpty()) {
						System.out.println("NO");
						continue outer;
					}
					
					stack.pop();
					
				}
			}
			
			if(stack.isEmpty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
			
			
		}
		
		
	}
	
}
