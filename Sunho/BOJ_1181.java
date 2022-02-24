package com.boj.day20220209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1181 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num=Integer.parseInt(br.readLine());
		
		String[] strArr = new String[num];
		
		int max=0;
		
		for(int i=0;i<num;i++) {
			strArr[i]=br.readLine();
			
			if(max<strArr[i].length()) {
				max=strArr[i].length();
			}
		}
		
		br.close();
		
		Arrays.sort(strArr,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				if(o1.length()==o2.length()) {
					return o1.compareTo(o2);
				}
				
				else {
					return o1.length()-o2.length();
				}
			}
		});
		
		System.out.println(strArr[0]);
		
		for(int i=1;i<num;i++) {
			System.out.println(strArr[i]);
		}
		
		
//		
//		//문자길이별 문자들 분배해서 저장
//		String[][] arr=new String[max][max];
//		//배열별 단어개수
//		int[] intArr = new int[max];
//		for(int i=0;i<max;i++) {
//			int leng=strArr[i].length();
//			
//			if(Arrays.asList(arr[leng-1]).contains(strArr[i])) {
//				continue;
//			}
//			
//			int maxleng=0;
//			for(int j=0;j<arr[leng-1].length;j++) {
//				if(arr[leng-1][j]==null) {
//					maxleng=j;
//					break;
//				}
//			} 
//			
//			
//			arr[leng-1][maxleng]=strArr[i];
//			intArr[i]=maxleng;
//		}
//		
//		//확인용
//		int cnt=1;
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr[i].length;j++) {
//				
//				if(arr[i][0]==null) {
//					continue;
//				}else if(arr[i][j]==null) {
//					continue;
//				}else {
//					System.out.println(cnt+":+arr["+i+"]["+j+"] : "+arr[i][j]);
//					cnt++;
//				}
//			}
//		}
//		
//		Arrays.sort(arr, );
		//순서바꿔서 넣어주기
//		String[][] result=new String[max][];
//		for(int i=0;i<max;i++) {
//			int leng=intArr[i];
//			System.out.println("leng : "+leng);
//			
//			result[i]=new String[leng];
//			
//			for(int j=leng-1;j>=0;j++) {
//				
//				for(int k=0;k<j;k++) {
//					String A=arr[i][k];
//					String B=arr[i][k+1];
//					
//					for(int l=0;l<leng;l++) {
//						if((int)A.charAt(l)>(int)B.charAt(l)) {
//							String temp=arr[i][k];
//							arr[i][k]=arr[i][k+1];
//							arr[i][k+1]=temp;
//							break;
//						}
//					}
//				}
//				
//			}
//			
//		}
		
//		//순서대로 담기
//		for(int i=0;i<)

		
		
//		for(int i=0;i<result.length;i++) {
//			for(int j=0;j<result[i].length;j++) {
//				System.out.println(result[i][j]);
//			}
//		}	
	}
}
