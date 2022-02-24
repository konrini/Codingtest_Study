package com.boj.day20220220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13300_방배정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] whole = br.readLine().split(" ");
		
		//전체 학생 수 
		int N = Integer.parseInt(whole[0]);
		//한 방에 들어가는 최대 학생 
		int K = Integer.parseInt(whole[1]);
		
		//필요한 최소 방의 개수 
		int count=0;
		
		//학년 분
		int[][] students = new int[7][2];
		for(int i=0;i<N;i++) {
			String[] student=br.readLine().split(" ");
			//성별 
			int S=Integer.parseInt(student[0]);
			//학년
			int Y=Integer.parseInt(student[1]);
			//각 학년과 성별에 맞는 곳에 1씩 키워준다.
			students[Y][S]++;
			
		}
		
		for(int i=1;i<=6;i++) {
			for(int j=0;j<=1;j++) {
				
				if(students[i][j]%K==0) {
					count+=students[i][j]/K;
				}else {
					count+=(students[i][j]/K)+1;
				}
				
				
			}
		}
		
		System.out.println(count);
		
		
		
		
	}
}
