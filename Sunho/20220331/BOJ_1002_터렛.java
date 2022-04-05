package com.boj.day20220330;

import java.util.Scanner;

public class BOJ_1002_터렛 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int N=sc.nextInt();
		
		for(int idx=0;idx<N;idx++) {
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			int r1=sc.nextInt();
			
			
			int x2=sc.nextInt();
			int y2=sc.nextInt();
			int r2=sc.nextInt();
			
			
			double distance = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
			
			int rSum=r1+r2;
			
			int result=-1;
			
			
			//같은 경우를 먼저 해야 아래에서 에러가 나지 않는다!!(일단 처리하고 시작하자는 뜻)
			if(distance==0 && r1==r2) {
				
			}
			
			//안만나는 경우
			//  두 원 밖  한원 안에 들어감 
			else if(distance>rSum || (distance+Math.min(r1, r2)<Math.max(r1, r2))) {
				
				result=0;
				
			}
			//한점 
			//두 원 밖의 한점에서 만나는 경우 || 안의 원에서 한 점에서 만나는 경우 
			else if(distance==rSum || (distance+Math.min(r1, r2)==Math.max(r1, r2))) {
				result=1;
			}
			//두 점에서 만나는 경우 
			else if(distance<rSum ) {
				result=2;
			}
			
			System.out.println(result);
		}
	}
}