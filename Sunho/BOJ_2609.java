package com.boj.day20220211;

import java.util.Scanner;

public class BOJ_2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		String[] strArr= str.split(" ");
		
		int num1=Integer.parseInt(strArr[0]);
		int num2=Integer.parseInt(strArr[1]);
		
		int max=1;
		int min=1;
		
		if(num1>num2) {
			max=num1;
			min=num2;
		}else if(num2>num1) {
			max=num2;
			min=num1;
		}else {
			System.out.println(num1);
			System.out.println(num1);
			return;
		}
		
		
		if(max%min==0) {
			System.out.println(min);
			System.out.println(max);
			return;
		}
		
		
		int gcd=1;
		for(int i=min;i>=1;i--) {
			if(min%i==0 && max%i==0) {
				gcd=i;
				break;
			}
		}
		
		int lcm=gcd*(max/gcd)*(min/gcd);


		
		System.out.println(gcd);
		System.out.println(lcm);
		
	}
}
