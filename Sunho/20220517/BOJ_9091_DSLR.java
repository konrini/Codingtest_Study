package com.boj.day20220517;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_9091_DSLR {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			
			int first = sc.nextInt();
			int second =sc.nextInt();
			
			String[] arr = new String[10000];
			Arrays.fill(arr, "");
			
			boolean[] visited=new boolean[10000];
			Queue<Integer> que = new LinkedList<>();
			
			//BFS가즈아!! 
			visited[first]=true;
			
			que.add(first);
			
			while(!que.isEmpty() && !visited[second]) {
				
				int num = que.poll();
				
				int D =(2*num)%10000;
				int S = (num==0)?9999:num-1;
				int L = (num%1000)*10+num/1000;
				int R = (num%10)*1000+num/10;
				
				if(!visited[D]) {
					arr[D]=arr[num]+"D";
					visited[D]=true;
					que.add(D);
				}
				
				if(!visited[S]) {
					arr[S]=arr[num]+"S";
					visited[S]=true;
					que.add(S);
				}
				
				if(!visited[L]) {
					arr[L]=arr[num]+"L";
					visited[L]=true;
					que.add(L);
				}
				
				if(!visited[R]) {
					arr[R]=arr[num]+"R";
					visited[R]=true;
					que.add(R);
				}
				
			}
			
			
			System.out.println(arr[second]);
			
			
		}
	}
}