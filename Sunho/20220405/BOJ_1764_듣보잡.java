package com.boj.day20220405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BOJ_1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str1=br.readLine().split(" ");
		
		int N=Integer.parseInt(str1[0]);
		int M=Integer.parseInt(str1[1]);
		
		Set<String> set= new HashSet<>();
		
		for(int i=0;i<N;i++) {
			set.add(br.readLine());
		}
		
		int cnt=0;
		List<String> list=new ArrayList<>();
		for(int i=0;i<M;i++) {
			String str=br.readLine();
			if(set.contains(str)) {
				cnt++;
				list.add(str);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt+"\n");
		
		Collections.sort(list);
		for(String s : list) {
			sb.append(s+"\n");
		}
		
		System.out.println(sb);
		
	}
}