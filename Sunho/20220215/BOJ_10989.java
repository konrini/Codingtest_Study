package com.boj.day20220216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		
		int[] resultArr = new int[num];
		
		for(int i=0;i<num;i++) {
			resultArr[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(resultArr);
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<num;i++) {
			sb.append(resultArr[i]+"\n");
		}
		
		System.out.println(sb.toString());
		
	}
}
