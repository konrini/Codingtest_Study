package com.boj.day20220315;

import java.util.Scanner;

public class BOJ_2941_크로아티아 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int cnt=0;
		
		int index=0;
		
		while(index<str.length()) {
			
			
			if(index==str.length()-1) {
				cnt++;
				break;
			}
			
			char c=str.charAt(index);
			
			if((c=='c'||c=='s'||c=='z')&&str.charAt(index+1)=='=') {
				cnt++;
				index+=2;
			
			}else if((c=='c'||c=='d')&&str.charAt(index+1)=='-') {
				cnt++;
				index+=2;
			}else if((c=='l'||c=='n')&&str.charAt(index+1)=='j') {
				cnt++;
				index+=2;
			}else if(index<str.length()-2) {
				if(str.charAt(index)=='d' && str.charAt(index+1)=='z' && str.charAt(index+2)=='=') {
					cnt++;
					index+=3;
				}else {
					cnt++;
					index++;
				}
			}else {
				cnt++;
				index++;
			}
		}
		
		
		System.out.println(cnt);
		
	}
	
}