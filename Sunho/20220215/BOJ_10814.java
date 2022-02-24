package com.boj.day20220215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
public class BOJ_10814 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		
		String[] strArr = new String[num];
		
		for(int i=0;i<num;i++) {
			strArr[i]=br.readLine();
		}
		
		Arrays.sort(strArr,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				
				return Integer.parseInt(o1.split(" ")[0])-Integer.parseInt(o2.split(" ")[0]);
				
			}
		});
		
		for(int i=0;i<num;i++) {
			System.out.println(strArr[i]);
		}
		
	}
}
