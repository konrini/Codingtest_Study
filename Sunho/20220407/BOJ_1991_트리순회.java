package com.boj.day20220407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_1991_트리순회 {
	//map으로 부모와 자식 노드를 저장하자.
	static Map<String, String[]> map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		map = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			String[] str = br.readLine().split(" ");
			//               0이 왼쪽, 1이 오른쪽 
			String[] str2= {str[1],str[2]};
			
			map.put(str[0], str2 );
			
		}
		StringBuilder sb ;
		
		
		sb= new StringBuilder();
		System.out.println(preorder("A", sb));
		
		sb= new StringBuilder();
		System.out.println(inorder("A",sb));
		
		sb= new StringBuilder();
		System.out.println(postorder("A",sb));
		
	}

	private static StringBuilder postorder(String str,StringBuilder sb) {
		
		String[] sArr = map.get(str);
		//종료부
		if(sArr[0].equals(".") && sArr[1].equals(".") ) {
			sb.append(str);
			return sb;
		}
		
		
		//재귀부
		if(!sArr[0].equals(".")) {
			sb=postorder(sArr[0],sb);
		}
		if(!sArr[1].equals(".")) {
			sb=postorder(sArr[1],sb);
		}
		
		sb=sb.append(str);
		
		return sb;
	}

	private static StringBuilder inorder(String str,StringBuilder sb) {
		String[] sArr = map.get(str);
		//종료부
		if(sArr[0].equals(".") && sArr[1].equals(".") ) {
			sb.append(str);
			return sb;
		}
		
		
		//재귀부
		if(!sArr[0].equals(".")) {
			sb=inorder(sArr[0],sb);
		}
		
		sb=sb.append(str);
		
		if(!sArr[1].equals(".")) {
			sb=inorder(sArr[1],sb);
		}
		
		
		
		return sb;
		
	}

	private static StringBuilder preorder(String str,StringBuilder sb) {
		String[] sArr = map.get(str);
		//종료부
		if(sArr[0].equals(".") && sArr[1].equals(".") ) {
			sb.append(str);
			return sb;
		}
		
		
		//재귀부
		sb=sb.append(str);
		
		if(!sArr[0].equals(".")) {
			sb=preorder(sArr[0],sb);
		}
		
		
		
		if(!sArr[1].equals(".")) {
			sb=preorder(sArr[1],sb);
		}
		
		
		
		return sb;
		
		
	}
	
}