package com.boj.day20220216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_11650 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		String[] arr = new String[num];
		//문자열로 넣어주기
		for(int i=0;i<num;i++) {
			arr[i]=br.readLine();
		}
		//x좌표를 먼저 비교하고, y좌표를 비교하자
		
		Arrays.sort(arr,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				if(Integer.parseInt(o1.split(" ")[0])!=Integer.parseInt(o2.split(" ")[0])) {
					return Integer.parseInt(o1.split(" ")[0])-Integer.parseInt(o2.split(" ")[0]);
				}
				
				return Integer.parseInt(o1.split(" ")[1])-Integer.parseInt(o2.split(" ")[1]);
			}
			
		});
		
		for(String i:arr) {
			System.out.println(i);
		}
		
		
		
	}
}
