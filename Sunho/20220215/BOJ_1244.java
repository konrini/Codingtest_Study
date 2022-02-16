package com.boj.day20220216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1244 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		String[] strArr = br.readLine().split(" ");
		int[] arr = new int[num];
		
		//arr배열에 값 하나씩 넣어서 준비
		for(int idx=0;idx<num;idx++) {
			arr[idx]=Integer.parseInt(strArr[idx]);
		}
		
		//총 시도횟수
		int cnt=Integer.parseInt(br.readLine());
		
		//성별과 받은 수
		int[][] doing=new int[cnt][2];
		
		for(int i=0;i<cnt;i++) {
			
			String[] sArr=br.readLine().split(" ");
			doing[i][0]=Integer.parseInt(sArr[0]);
			doing[i][1]=Integer.parseInt(sArr[1]);
			
		}
		
		for(int i=0;i<doing.length;i++) {
			if(doing[i][0]==1) {
				int start = doing[i][1]-1;
				
				while(start<arr.length) {
					
					
					arr[start]=(arr[start]+1)%2;
					
					start+=doing[i][1];
				}
				
			}else {
				int start = doing[i][1]-1;
				int minLen = Math.min(start, arr.length-1-start);
				
				
				for(int j=minLen;j>0;j--) {
					boolean check=true;
					//해당범위 내에서 check에 걸리면 회문이 아니기 때문에 다음 for문을 실행하고 true면 종료 후 minLen을 반환하자
					for(int k=j;k>=0;k--) {
						if(arr[start+k]!=arr[start-k]) {
							check=false;
							break;
						}
					}
					
					//회문의 길이의 최대값 구했다!(양쪽으로 봤을 때 한쪽의 길이)
					if(check) {
						minLen=j;
						break;
					}
				}
				
				//왼쪽 길이부터 오른쪽 길이까지 arr부분 다 바꿔줌
				for(int j=start-minLen;j<=start+minLen;j++) {
					arr[j]=(arr[j]+1)%2;
				}
				
				
				
			}
		}
		
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
		
	}
}
