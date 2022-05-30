package com.boj.day20220510;

import java.util.Scanner;

public class BOJ_1992_쿼드트리 {
	static int[][] arr;
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		
		arr= new int[N][N];
		
		for(int i=0;i<N;i++) {
			char[] cArr=sc.next().toCharArray();
			for(int j=0;j<N;j++) {
				arr[i][j]=cArr[j]-'0';
			}
		}
		
		
		
		sb=new StringBuilder();
		//시작좌표 ,한변의 길이 
		check(0,0,N);
		
		
		System.out.println(sb.toString());
	}
	
	
	
	private static void check(int r, int c, int size) {
		
//		System.out.println("r : "+r+", c : "+c+", size : "+size);
		
		//마지막 사이즈로 오면 끝
		if(size==1) {
			sb.append(arr[r][c]+"");
			return;
		}
		
		int st=arr[r][c];
		
		boolean check=true;
		
		outer:
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				if(arr[i][j]!=st) {
					check=false;
					break outer;
				}
			}
		}
		
		//색이 전부 통일인 경
		//그러면 숫자 넣어주고 return 하면 된다.
		if(check) {
			sb.append(st+"");
			return;
		}
		//아닌 경우는 4개로 쪼개서 더 출발해야 한다.
		//이 경우, 숫자가 더 들어가기 때문에 앞뒤로 괄호를 넣어주고 재귀를 돌려야 한다.
		else {
			sb.append("(");
			//왼쪽 위 
			check(r,c,size/2);
			//오른쪽 위 
			check(r,c+size/2,size/2);			
			//왼쪽 아래 
			check(r+size/2,c,size/2);
			//오른쪽 아래 
			check(r+size/2,c+size/2,size/2);
			sb.append(")");
			
		}
		
		
		
	}
}
