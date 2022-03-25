package com.boj.day20220325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11723_집합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int c=Integer.parseInt(br.readLine());
		
		
		
		
		
		boolean[] arr = new boolean[21]; 

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<c;i++) {
			
			String[] str = br.readLine().split(" ");
			
			int num=0;
			if(!(str[0].equals("all") || str[0].equals("empty"))) {
				num=Integer.parseInt(str[1]);
			}
			switch(str[0]) {
			case "add":
				
				arr[num]=true;
				break;
			case "remove":
				arr[num]=false;
				break;
			case "check":
				if(arr[num]) {
					sb.append(1+"\n");
				}else {
					sb.append(0+"\n");
				}
				break;
			case "toggle":
				arr[num]=!arr[num];
				break;
			case "all":
				for(int j=1;j<=20;j++) {
					
					if(!arr[j])
						arr[j]=true;
					
					
				}
				break;
			case "empty":
				for(int j=1;j<=20;j++) {
					
					if(arr[j])
						arr[j]=false;
					
					
				}
				break;
			}
			
		}
		
		System.out.println(sb.toString());
	}
}
