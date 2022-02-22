package com.boj.day20220220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8320_직사각형을만드는방법 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		int count=0;
		for(int i=1;i<=num;i++) {
			for(int j=1;j<=i/2;j++) {
				if(i%j==0) {
					
					if(j>i/j) {
						break;
					}
					count++;
				}
				
				
			}
		}
		
		System.out.println(count+1);
	}
}
