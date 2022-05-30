package com.boj.day20220510;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11403_경로찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		
		int[][] arr= new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		//정답 행렬
		int[][] answer= new int[N][N];
		
		
		//각 출발지별로 갈수 있는 곳들을 전부 계산해보자
		for(int idx=0;idx<N;idx++) {
			//방문처리
			boolean[] visited=new boolean[N];
			//BFS를 처리할 큐
			Queue<Integer> que = new LinkedList<>();
			
			que.add(idx);
			
			while(!que.isEmpty()) {
				//System.out.println("돈다돌아");
				int num=que.poll();
				
				for(int i=0;i<N;i++) {
					
					//   다음 행선지         방문 여부
					if(arr[num][i]==1 && !visited[i]) {
						que.add(i);
						answer[idx][i]=1;
						visited[i]=true;
					}
				}
				
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
		
//		StringBuilder sb = new StringBuilder();
//		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				sb.append(answer[i][j]).append(" ");
//			}
//			sb.append("\n");
//		}
//		
//		System.out.println(sb);
		
	}
}
