package com.boj.day20220412;

import java.util.Scanner;

public class BOJ_2630_색종이만들기 {
	
	static int[][] arr;
	static int blue,white;
	static boolean[][] bArr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		
		arr=new int[N][N];
		bArr=new boolean[N][N];
		blue=0;
		white=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		
		int len=N;
		int block=1;
		
		while(len>0) {
			
			for(int i=0;i<block;i++) {
				for(int j=0;j<block;j++) {
					
					int r=i*len;
					int c=j*len;
					
					if(!bArr[r][c]) {
						check(r,c,len);
					}
					
					
				}
			}
			
			
			
			len/=2;
			block*=2;
		}
		
		System.out.println(white);
		System.out.println(blue);
		
		
	}
	
	//                       시작점 row , column, 한변의 길이
	private static void check(int r, int c, int len) {
		
		int temp=arr[r][c];
		
		for(int i=r;i<r+len;i++) {
			for(int j=c;j<c+len;j++){
				
				//색종이 색이 다름! 그러니까 잘가용 ㅎㅎ
				if(arr[i][j]!=temp) {

					return;
				}
				
			}
		}
		
		//밑은 남아있는 것, 즉 색종이 색이 통일되어 있다는 뜻이다!!
		//하나의 숫자로 되어있기 때문에 색종이로 취급!
		if(temp==1) {
			blue++;
		}else {
			white++;
		}
		
		//방문체크 해주기!
		for(int i=r;i<r+len;i++) {
			for(int j=c;j<c+len;j++){
				bArr[i][j]=true;
			}
		}

		
		
	}
}
