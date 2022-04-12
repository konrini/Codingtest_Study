package com.boj.day20220405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BOJ_11725_트리의부모찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		int N= Integer.parseInt(br.readLine());
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		for(int i=0;i<N-1;i++) {
			String[] str = br.readLine().split(" ");
			
			int num1=Integer.parseInt(str[0]);
			int num2=Integer.parseInt(str[1]);
			
			
			//한번씩 넣어주기
			List<Integer> list;
			if(map.containsKey(num1)) {
				list =map.get(num1);
			}else {
				list=new ArrayList<>();
			}
			
			list.add(num2);
			map.put(num1, list);
			
			
			//두번째 넣어주기
			List<Integer> list2;
			if(map.containsKey(num2)) {
				list2 =map.get(num2);
			}else {
				list2=new ArrayList<>();
			}
			
			list2.add(num1);
			map.put(num2, list2);
		}
		
		int[] parents = new int[N+1];
		int cnt=1;
		
		
		Queue<Integer> que = new LinkedList<>();
		que.add(cnt);
		
		while(!que.isEmpty()) {
			
			int parent=que.poll();
			
			List<Integer> list = map.get(parent);
			
			for(int a :list) {
				
				if(parents[a]==0) {
					parents[a]=parent;
					que.add(a);
				}
				
			}
			
	//		System.out.println(que.size());
		}
		
		for(int i=2;i<parents.length;i++) {
			System.out.println(parents[i]);
		}
		
		
	}
}
