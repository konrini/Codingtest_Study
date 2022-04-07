package com.boj.day20220405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_17219_비밀번호찾기 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s=br.readLine().split(" ");
		
		int N= Integer.parseInt(s[0]);
		int M= Integer.parseInt(s[1]);
		
	
		
		//map의 키값으로 받아서 시간좀 줄여보자!
        //이메일 주소의 맨 앞의 알파벳을 기준으로 배열을 쪼개서 보관하자
		Map<Character,List<String[]>> map = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			
			String[] str=br.readLine().split(" ");
			//이미 들어간 값이 있으면, 꺼내서 업데이트만 해주면 된다.
			if(map.containsKey(str[0].charAt(0))) {
				
				List<String[]> list=map.get(str[0].charAt(0));
				list.add(str);
				map.put(str[0].charAt(0), list);
			//없으면 리스트 하나 만들어서 넣어주자	
			}else {
				List<String[]> list= new ArrayList<>();
				list.add(str);
				map.put(str[0].charAt(0), list);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			
			String str = br.readLine();
			//맨 알파벳에 맞는 것만 꺼내서 비교해서 비교시간을 줄이자
			List<String[]> list=map.get(str.charAt(0));
			for(int j=0;j<list.size();j++) {
				
				
				if(list.get(j)[0].equals(str)) {
					sb.append(list.get(j)[1]+"\n");
                    break;
				}
				
				
				
			}
			
		}
		
		System.out.println(sb);
		
		
		
		
		
		
		
		
	}
}
