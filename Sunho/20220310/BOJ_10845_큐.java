package com.boj.day20220310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10845_큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		Queue<Integer> que = new LinkedList<>();
		//맨 뒤의 값들을 확인하기 위해서 넣을때마다 마지막 값을 넣을 변수선언! 이후 back에서 사용
		int check=0;
		
		for(int idx=0;idx<t;idx++) {
			
			
			String[] strArr = br.readLine().split(" ");
			
			
			
			
			if(strArr.length==1) {
				
				String str = strArr[0];
				
				switch(str) {
				
				case "front": 
					
					if(que.isEmpty()) {
						System.out.println(-1);
					}else {
						System.out.println(que.peek()); 
					}
					
					
					break;
				case "back": 
					if(que.isEmpty()) {
						System.out.println(-1);
					}else {
						System.out.println(check); 
					}
					
					break;
				
				
				
				case "size": 
					
					System.out.println(que.size());
					
					break;
				case "empty": 
					if(que.isEmpty()) {
						System.out.println(1);
					}else {
						System.out.println(0);
					}
					
					break;
				case "pop":
					if(que.isEmpty()) {
						System.out.println(-1);
					}else {
						System.out.println(que.poll()); 
					}
					
					break;
				}
				
			//push 밖에 없다!	
			}else if(strArr.length==2){
				int num=Integer.parseInt(strArr[1]);
				
				que.add(num);
				
				check=num;
				
				
			}
			
			
			
		}
		
		
		
	}
}
