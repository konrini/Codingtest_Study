package com.boj.day20220412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BOJ_9375_패션왕신해빈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int tc=Integer.parseInt(br.readLine());
		
		for(int index=0;index<tc;index++) {
			int num=Integer.parseInt(br.readLine());
					
			Map<String, Set<String>> map = new HashMap<>();
			
			for(int i=0;i<num;i++) {
				String[] str = br.readLine().split(" ");
				
				Set<String> set;
				if(!map.containsKey(str[1])) {
					set=new HashSet<>();
				}else {
					set=map.get(str[1]);
				}
				
				set.add(str[0]);
				map.put(str[1], set);
				
			}
			
			
			int sum=1;
			
			List<String> list = new ArrayList<>(map.keySet());
			
			for(String s : list) {
				int size=map.get(s).size()+1;
				sum*=size;
			}
			
			System.out.println(sum-1);
			
			
		}
		
	}
}
