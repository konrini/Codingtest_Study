package com.boj.day20220308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949_균형잡힌세계 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String str;
		
		while(true) {
			
			str=br.readLine();
			if(str.equals(".")) {
				break;
			}
			//정상운행중인지 체크
			boolean check=true;
			
			Stack<Character> stack = new Stack<>();
			
			for(int i=0;i<str.length();i++) {
				
				char s=str.charAt(i);
				//여는 괄호는 무조건들어가기
				if(s=='[' || s=='(') {
					
					stack.push(s);
				
				//닫는 괄호는 조건 찾기
				}else if(s==']'||s==')'){
					//1. 비어있으면 당연히 에러
					if(stack.isEmpty()) {
						check=false;
						break;
					}
					
					//짝이 맞으면 빼주기
					if((stack.peek()=='[' && s==']')||(stack.peek()=='(' && s==')')) {
						stack.pop();
					//2.짝이 안맞으면 에러	
					}else {
						check=false;
						break;
					}
				}
			}
			
			//3. 다 안빠지고 남는게 있어도 에러
			if(!stack.isEmpty()) {
				check=false;
			}

			
			if(check) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
			
			
			
		}
		
	}
}
