package com.boj.day20220223;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309_일곱난쟁이 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int[] arr=new int[9];
		
		//전체
		int sum=0;
		for(int i=0;i<9;i++) {
			arr[i]=sc.nextInt();
			sum+=arr[i];
		}
		
		//차라리 전체 합에서 100을 빼서, 남은 두 명의 키의 합이 전체와 100의 차이인지를 비교하자 
		int distance= sum-100;
		
		//난쟁이가 아닌 사람들의 키의 인덱
		int firstIdx=-1;
		int secondIdx=-1;
		//반복문을 돌면서 distance만큼의 키의 합이 있는지 확
		for(int i=0;i<9-1;i++) {//더 작은 값이므로 하나 빼서 계
			for(int j=i+1;j<9;j++) {
				if(arr[i]+arr[j]==distance) {
					firstIdx=i;
					secondIdx=j;
					break; //아무거나 출력하면 되기 때문에 걸리면 
				}
			}
		}
		
		int first=arr[firstIdx];
		int second=arr[secondIdx];
		
		Arrays.sort(arr);
		
		for(int i=0;i<9;i++) {
			if(arr[i]==first || arr[i]==second) {
				continue;
			}
			System.out.println(arr[i]);
		}
		
		
		
		
	}
}

