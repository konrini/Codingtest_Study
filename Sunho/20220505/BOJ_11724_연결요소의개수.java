package com.boj.day20220503;

import java.util.Scanner;

public class BOJ_11724_연결요소의개수 {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		arr=new int[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i]=i;
		}
		
		//서로소 집합 만들기. 
		for(int i=0;i<M;i++) {
			
			int first = findset(sc.nextInt());
			int second = findset(sc.nextInt());
			
			if(first!=second) {
				union(first, second);
			}
		}
		
//		System.out.println(Arrays.toString(arr));
		
		//서로소 집합의 개수 세기 
		boolean[] visited = new boolean[N+1];
		int cnt=0;
		
		for(int i=1;i<arr.length;i++) {
			
			int a = findset(arr[i]);
			
			if(!visited[a]) {
				cnt++;
				visited[a]=true;
			}
		}
		
		
		System.out.println(cnt);
		
		
	}
	
	private static int findset(int a) {
		
		if(arr[a]==a) {
			return a;
		}
		
		
		return arr[a]=findset(arr[a]);
	}
	
	private static void union(int a, int b) {
		int max=Math.max(a, b);
		int min=Math.min(a, b);
		
		arr[max]=min;
	}
	
	
	
	
}