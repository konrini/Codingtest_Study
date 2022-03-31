package com.boj.day20220329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1149_RGB거리_재귀 {
	
	static int[] cases= {0,1,2};
	static int num=0;
	static int[][] arr;
	static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		num = Integer.parseInt(br.readLine());
		//3개씩 넣자
		arr=new int[num][3];
		
		for(int i=0;i<num;i++) {
			
			String[] str = br.readLine().split(" ");
			//Red
			arr[i][0]=Integer.parseInt(str[0]);
			//Green
			arr[i][1]=Integer.parseInt(str[1]);
			//Blue
			arr[i][2]=Integer.parseInt(str[2]);
			
			
		}
		
		
		
		
		//이건 모든 케이스를 다 봐야하기 때문에 재귀함수로 가보자!
		coloring(0, 0 ,0);
		coloring(0, 1 ,0);
		coloring(0, 2 ,0);
		
		System.out.println(min);
	}
	
								//비용합  색깔번호(0,1,2)	배열번호 (집이 서있는 길의 번호로 생각하면 된다) 
	public static void coloring(int sum, int colorIdx, int count) {
		
		
		
		
		
		//종료부
		//넘어서면 볼 거 없다!!
		//마지막까지 간 후, min까지 체크하기 
		if(sum>min || count==num) {
			min=Math.min(sum, min);
			return;
		}
		
		
		
		//재귀
		
		sum+=arr[count][colorIdx];
		
		coloring(sum , (colorIdx+1)%3, count+1);
		
		coloring(sum , (colorIdx+2)%3, count+1);
		
	}
}