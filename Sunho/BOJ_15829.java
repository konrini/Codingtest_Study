package com.boj.day20220208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj15829 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num=Integer.parseInt(br.readLine());
		String str = br.readLine();

		
		
		int[] arr = new int[num];
		
		for(int i=0;i<str.length();i++) {
			arr[i]=str.charAt(i)-'a'+1;
		}
		
		long H=0;
		long r=1;
		
		for(int i=0;i<str.length();i++) {
			H+=((arr[i]*r)%1234567891);
			r*=31;
			r%=1234567891;
		}
		
		System.out.println(H);
		
	}
}
