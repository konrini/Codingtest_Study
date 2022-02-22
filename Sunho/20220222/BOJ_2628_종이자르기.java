package com.boj.day20220220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2628_종이자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] square = br.readLine().split(" ");
		
		//0부터 최대 인덱스까지 
		int width=Integer.parseInt(square[0]);
		int height = Integer.parseInt(square[1]);
		
		//전체 개
		int count = Integer.parseInt(br.readLine());
		

		List<Integer> row=new ArrayList<>();
		List<Integer> col=new ArrayList<>();
		
		//차이를 구할 것ㅇ기 때문에 기준이 될 0은 미리 넣어둔
		row.add(0);
		col.add(0);
		
		//차이를 가로세로별로 확인하기 위해서 따로따로 넣어둔다.
		for(int i=0;i<count;i++) {
			
			String[] str = br.readLine().split(" ");
			
			if(str[0].equals("0")) {
				row.add(Integer.parseInt(str[1]));
			}else {
				col.add(Integer.parseInt(str[1]));
			}
		}
		
		row.add(height);
		col.add(width);
		//오름차순으로 정렬. 그래서 차이를 구하
		Collections.sort(row);
		Collections.sort(col);
		
//		for(int i=0;i<row.size();i++) {
//			System.out.println(row.get(i));
//		}
//		for(int i=0;i<col.size();i++) {
//			System.out.println(col.get(i));
//		}
		
		int max=0;
		
		for(int i=1;i<row.size();i++) {
			for(int j=1;j<col.size();j++) {
				int surface= (row.get(i)-row.get(i-1))*(col.get(j)-col.get(j-1));
				
				if(surface>max) {
					max=surface;
				}
			}
		}
		
		
		System.out.println(max);
		
	}
}
