package com.boj.day20220308;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_10773_제로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		int t = sc.nextInt();
		
		int sum=0;
		//앞에 있는 숫자를 지워야하는 구조이기 때문에 stack을 써서 해보자!
		Stack<Integer> stack = new Stack<>();
		
	
		for(int i=0;i<t;i++) {
			
			int num=sc.nextInt();
			
			//0이 아니면 stack에 넣고 sum에 더해준다.
			if(num!=0) {
				stack.push(num);
				sum+=num;
			//0이면 그 전에 0이 아닌 수를 빼기 때문에, 비어있지 않으면 pop해서 그만큼 sum에서 빼준다.	
			}else if(num==0) {
				
				if(!stack.isEmpty()) {
					int a=stack.pop();
					sum-=a;
				}
				
			}
			
		}
		
		System.out.println(sum);
				
		
		
	}
}

