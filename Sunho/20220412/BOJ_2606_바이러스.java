package com.boj.day20220412;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2606_바이러스 {
	
	static boolean[] visited;
	
	//BFS로 가자!
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int link=sc.nextInt();;
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		
		visited = new boolean[n+1];
		
		for(int i=0;i<link;i++) {
			int num1=sc.nextInt();
			int num2=sc.nextInt();
			
			
			List<Integer> list ;
			//num1 에 num2 넣어주기 
			if(!map.containsKey(num1)) {
				list= new ArrayList<Integer>();
				
			}else {
				list=map.get(num1);
			}
			list.add(num2);
			map.put(num1, list);
			
			//num2 에 num1 넣어주기 	
			if(!map.containsKey(num2)) {
				list= new ArrayList<Integer>();
				
			}else {
				list=map.get(num2);
			}
			list.add(num1);
			map.put(num2, list);
		}
		
		//BFS시작
		Queue<Integer> que= new LinkedList<>();
		que.add(1);
		
		while(!que.isEmpty()) {
			int key=que.poll();
			
			visited[key]=true;
			List<Integer> list = map.get(key);
			
			for(int i : list) {
				if(!visited[i]) {
					que.add(i);
				}
			}
					
		}
		
		int cnt=0;
		
		for(int i=1;i<=n;i++) {
			if(visited[i]) {
				cnt++;
			}
		}
		
		System.out.println(cnt-1);
		
		
		
		
	}
}