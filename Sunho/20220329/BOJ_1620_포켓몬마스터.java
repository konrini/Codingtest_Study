package com.boj.day20220329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_1620_포켓몬마스터 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str1 = br.readLine().split(" ");
		
		int N=Integer.parseInt(str1[0]);
		int M=Integer.parseInt(str1[1]);
		
		//이름을 담을 배열
		String[] arr= new String[N];
		Map<String, Integer> map = new HashMap<>();
 		
		
		
		for(int i=0;i<N;i++) {
			arr[i]=br.readLine();
			map.put(arr[i], i+1);
		}
		
		//문제 답 찾으러 가기
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			
			String str = br.readLine();
			
			//이런 경우, 숫자이다. 
			if(str.charAt(0)>='0' && str.charAt(0)<='9') {
				sb.append(arr[Integer.parseInt(str)-1]+"\n");
			}
			//나머지 경우, 이름이다.
			else {
				
				sb.append(map.get(str)+"\n");
				

			}
			
			
		}
		
		System.out.println(sb.toString());
		
	}
}
