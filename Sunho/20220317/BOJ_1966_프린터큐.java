package com.boj.day20220317;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1966_프린터큐 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t= sc.nextInt();
		
		for(int idx=0;idx<t;idx++) {
			
			//개수
			int N=sc.nextInt();
			//해당 인덱스. 이 부분을 -로 바꿔보자!(확인용도)
			int M=sc.nextInt();
			
			Queue<Integer> que = new LinkedList<>();
			
			//우선순위 파악을 위한 배열
			int[] arr = new int[N];
			
			for(int i=0;i<N;i++) {
				
				int num=sc.nextInt();
				arr[i]=num;
				//타깃 숫자 마킹
				if(i==M) {
					num= -1*num;
				}
				
				//큐에 넣어주기
				que.add(num);
				
			}
			
			
			Arrays.sort(arr);
			
//			for(int i=0;i<que.size();i++) {
//				int num=que.poll();
//				System.out.print(num+" ");
//				que.add(num);
//			}
//			System.out.println("============");
//			
//			for(int i=0;i<arr.length;i++) {
//				System.out.print(arr[i]+" ");
//				
//			}
			
			//우선순위 비교하면서 큐 돌려보자
			
			//우선순위 비교할 인덱스. 뒤에서부터 비교하자
			int index=N-1;
			
			int cnt=0;
			
			while(true) {
				//비교할 인덱스
				int max=arr[index];
				
				if(Math.abs(que.peek())==max) {
					
					if(que.peek()<0) {
						
						System.out.println(cnt+1);
						
						break;
					}else {
						//원하는 건 아니지만, 일단 나올 순서
						//빠지기
						que.poll();
						//인덱스 내리기(다음 인덱스 확인하러 가자)
						index--;
						
						cnt++;
						
					}
					
					
				}else {
					
					//무조건 더 작은 부분이 나오기 때문에, 빼낸 다음 다시 넣는다.
					
					int num=que.poll();
					
					que.add(num);
					
				}
				
				
			}
			
			
			
			
			
		}
		
	}
}