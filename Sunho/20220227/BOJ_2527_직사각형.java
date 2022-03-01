package com.boj.day20220223;

import java.util.Scanner;

public class BOJ_2527_직사각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int idx=0;idx<4;idx++) {
			
			int ax1=sc.nextInt();
			int ay1=sc.nextInt();
			
			int ax2=sc.nextInt();
			int ay2=sc.nextInt();
			
			int bx1=sc.nextInt();
			int by1=sc.nextInt();
			
			int bx2=sc.nextInt();
			int by2=sc.nextInt();
			
			
			if(ax1>bx2 || bx1>ax2 || ay1>by2 || by1>ay2) {
				System.out.println("d");
			}else if((ax1==bx2 && ay1==by2)||(ax2==bx1&&ay1==by2)||(ax2==bx1&&ay2==by1)||(ax1==bx2 &&ay2==by1 )) {
				System.out.println("c");
			}else if((ay2==by1 && ((ax1<=bx1 && bx1<ax2)||(bx1<=ax1 && ax1<bx2)))
					||(ax2==bx1 && ((ay1<=by1 && by1<ay2)||(by1<=ay1 && ay1<by2)))
					||(ay1==by2 && ((ax1<=bx1 && bx1<ax2)||(bx1<=ax1 && ax1<bx2)))
					||(ax1==bx2 && ((ay1<=by1 && by1<ay2)||(by1<=ay1 && ay1<by2)))) {
				
				System.out.println("b");
				
			}else {
				System.out.println("a");
			}

		}
		
		
	}
}