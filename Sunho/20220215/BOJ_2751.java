package com.boj.day20220214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BOJ_2751 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		int[] arr=new int[num];
		
		int max=0;
		
		for(int i=0;i<num;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		
		Arrays.sort(arr);
		
		

		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<num;i++) {
			sb.append(arr[i]).append('\n');
		}
		System.out.println(sb.toString());
		
	}
}
