package com.boj.day20220517;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_1244_최대상금 {
	static int[] arr;
	static List<Integer> list;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T =sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			max=0;
			//문자로 받아서 숫자로 정렬하기 
			char[] temp = sc.next().toCharArray();
			
			//각 숫자 넣기 
			arr= new int[temp.length];
			
			list=new ArrayList<>();
			
			for(int i=0;i<temp.length;i++) {
				arr[i]=temp[i]-'0';
			}
			
			//전부 몇번 해야하는지 
			int total=sc.nextInt();
			
			swap(0,total);
			
//			Collections.sort(list,Collections.reverseOrder());
			
			System.out.printf("#%d %d\n",tc,max);
			
		}
	}
	
	
	private static void swap(int idx, int cnt) {
		
		if(cnt==0 || idx==arr.length) {
			String str="";
			for(int i=0;i<arr.length;i++) {
				str+=arr[i];
			}
			
			int num=Integer.parseInt(str);
			max=Math.max(max, num);
			return;
			
		}
		
		for(int i=idx;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]<=arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
					
					swap(i,cnt-1);
					
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
				
				
			}
		}
		
	}
}