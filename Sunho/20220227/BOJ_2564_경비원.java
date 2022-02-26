package com.boj.day20220223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2564_경비원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] a=br.readLine().split(" ");
		
		int width=Integer.parseInt(a[0]);
//		System.out.println("width : "+width);
		int height=Integer.parseInt(a[1]);
//		System.out.println("height : "+height);
		//전체 개수
		int cases=Integer.parseInt(br.readLine());
		
		//위치 저장
		int[][] targets=new int[cases+1][3];
		for(int i=0;i<cases+1;i++) {
			String[] a1=br.readLine().split(" ");
			
			if(a1[0].equals("1")) {
				targets[i][0]=0;
				targets[i][1]=Integer.parseInt(a1[1]);
				//2번쨰 인덱스는 위치를 용이하게 파악하기 위한 용도(동,서,남,북)
				targets[i][2]=1;
			}else if(a1[0].equals("2")) {
				targets[i][0]=height;
				targets[i][1]=Integer.parseInt(a1[1]);
				targets[i][2]=2;
			}else if(a1[0].equals("3")) {
				targets[i][0]=Integer.parseInt(a1[1]);
				targets[i][1]=0;
				targets[i][2]=3;
			}else if(a1[0].equals("4")) {
				targets[i][0]=Integer.parseInt(a1[1]);
				targets[i][1]=width;
				targets[i][2]=4;
			}
		}
		
		int sumLength=0;
		
		for(int i=0;i<cases;i++) {
			int y=targets[cases][0];
			int x=targets[cases][1];
			
			int row=targets[i][0];
			int col=targets[i][1];
			//한곳 몰려있을 때
			if(targets[cases][2]==targets[i][2]) {
				if(targets[cases][2]==1 || targets[cases][2]==2) {
					sumLength+=Math.abs(x-col);
				}else {
					sumLength+=Math.abs(y-row);
				}
			//남,북에 하나씩	
			}else if(targets[cases][2]*targets[i][2]==2) {
				
				sumLength+=height;

				//					왼쪽으로       오른쪽으로
				sumLength+=Math.min(x+col, (width-x)+(width-col));

				
			//동,서에 하나씩	
			}else if(targets[cases][2]*targets[i][2]==12) {
				
				sumLength+=width;
				//					위쪽으로       아래쪽으로
				sumLength+=Math.min(x+row, (height-y)+(height-row));
			//바로 옆에 붙어있는 경우	
			}else {
				sumLength+=Math.abs(x-col);
				sumLength+=Math.abs(y-row);
			}
			
//			System.out.println(i+1+"번 째 : "+sumLength);
			
		}
		
		System.out.println(sumLength);
		
	}
}
