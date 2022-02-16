package com.boj.day20220214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_7568 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		
		int[] weight=new int[num];
		int[] height=new int[num];
		
//		//결과를 받을 배열. 하나씩 늘려가는 형태를 사용할 것. 그래서 가장 많이 받은 것부터 반대로 출력할 예정
//		int[] result=new int[num];
//		//result와 비교할 배열 필요.
//		int[] resultArr = new int[num];
		
		for(int i=0;i<num;i++) {
			String str = br.readLine();
			String[] strArr = str.split(" ");
			weight[i]=Integer.parseInt(strArr[0]);
			height[i]=Integer.parseInt(strArr[1]);
		}
		
		for(int i=0;i<num;i++) {
			
			int cnt=1;
			for(int j=0;j<num;j++) {
				if(weight[i]<weight[j] && height[i]<height[j]) {
					cnt++;
				}
			}
			
			System.out.print(cnt+" ");
			
		}
		
		
//		//기준별로 전체 비교하면서 덩치가 작은 것이 있으면 기준(i번째)카운트를 늘리고, 반대인 경우는 그 대상의 카운트를 늘린다.
//		for(int i=0;i<num-1;i++) {
//			for(int j=i+1;j<num;j++) {
//				
//				if(weight[i]>weight[j] && height[i]>height[j]) {
//					result[i]++;
//					resultArr[i]++;
//				}else if(weight[i]<weight[j] && height[i]<height[j]) {
//					result[j]++;
//					resultArr[j]++;
//				}
//				
//			}
//		}
//		
//		Arrays.sort(resultArr);
//
//		//마지막 순서담아주기
//		int[] results=new int[num];
//		for(int i=0;i<result.length;i++) {
//			for(int j=resultArr.length-1;j>=0;j--) {
//				if(resultArr[j]==result[i]) {
//					results[i]=result.length-j;
//					break;
//				}
//			}
//		}
//		
//		for(int i:results) {
//			System.out.print(i+" ");
//		}
//		
//		
//		
		
	}
}
