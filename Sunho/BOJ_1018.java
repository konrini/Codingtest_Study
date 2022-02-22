package com.boj.day20220209;

import java.util.Scanner;

public class BOJ_1018 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		
		
		int[][] intArr = new int[num1][num2];
		
		//숫자로 구
		for(int i=0;i<num1;i++) {
			String strs = sc.next(); 
			for(int j=0;j<num2;j++) {
				if(strs.charAt(j)=='B') {
					intArr[i][j]=1;
				}else {
					intArr[i][j]=0;
				}
			}
		}
		
		int count=num1*num2;//바꾸기 숫
		for(int a=0;a<num1-7;a++) {
			for(int b=0;b<num2-7;b++) {
				int min=0;
				int count1=0;
				
				for(int i=0;i<8;i++) {
					for(int j=0;j<8;j++) {
						
						if((a+i+b+j)%2==0) {
							if(intArr[a+i][b+j]==1) {
								count1+=1;
							}
						}else {
							if(intArr[a+i][b+j]==0) {
								count1+=1;
							}
						}
						
					}
				}
				
				int count2=0;
				outerLoop:
				for(int i=0;i<8;i++) {
					for(int j=0;j<8;j++) {
						
						if((a+i+b+j)%2==0) {
							if(intArr[a+i][b+j]==0) {
								count2+=1;
							}
						}else {
							if(intArr[a+i][b+j]==1) {
								count2+=1;
							}
						}
						
						if(count2>=count1) {
							min=count1;
							break outerLoop;
						}else {
							min=count2;
						}
						
						
					}
				}
				
				if(count>min) {
					count=min;
				}
				
				
			}
		}
		System.out.println(count);

	}
}
