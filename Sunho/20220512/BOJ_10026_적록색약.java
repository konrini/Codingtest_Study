package com.boj.day20220512;

import java.util.Scanner;

public class BOJ_10026_적록색약 {
	static int[] dr= {0,1,0,-1};
	static int[] dc= {1,0,-1,0};
	static char[][] arr;
	static boolean[][] normal;
	static boolean[][] unColor;
	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		
		arr = new char[N][N];
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.next().toCharArray();
		}
		
		
		
		//색을 구분하기 위해서 DFS식으로 문제를 풀어보자.
		//기준점을 잡고 상,하,좌,우로 그 색과 같은 것이 있는지 확인하는 것.
		normal=new boolean[N][N];
		unColor=new boolean[N][N];
		
		
		//DFS의 개수를 확인하기 위해서 넣어두자.
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!normal[i][j]) {
					
					char st=arr[i][j];
					check(i,j,st);
					cnt++;
				}
			}
		}
		
		System.out.print(cnt+" ");
		
		cnt=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!unColor[i][j]) {
					
					char st=arr[i][j];
					color(i,j,st);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

	
	//일반 방문체크 가자.
	private static void check(int r, int c, char st) {
		
		normal[r][c]=true;
		
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			//			방문 가능 여부(앞에 !있음)					문자가 같은지도 확인 
			if(!(nr<0||nr>=N||nc<0||nc>=N||normal[nr][nc]) && arr[nr][nc]==st) {
				check(nr,nc,st);
			}
			
		}
	}
	
	private static void color(int r, int c, char st) {
		
		unColor[r][c]=true;
		
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			//			방문 가능 여부(앞에 !있음)			
			if(!(nr<0||nr>=N||nc<0||nc>=N||unColor[nr][nc])) {
				
				//			둘 다 blue 					둘다 blue 아
				if((st=='B' &&arr[nr][nc]=='B')|| ((st!='B')&&(arr[nr][nc]!='B'))){
					color(nr,nc,st);
				}
				
			}
			
		}
	}
	
	
	
	
}
