package com.boj.day20220220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14696_딱지놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num= Integer.parseInt(br.readLine());
		
		for(int idx=0;idx<num;idx++) {
			/*1. a라는 애의 카드를 배열로 넣는다.*/
			String[] A= br.readLine().split(" ");
			//카드의 총 개수 
			int aCount=Integer.parseInt(A[0]);
			
			int[] aArr=new int[5];
			//순서대로 넣어주기 
			for(int i=1;i<=aCount;i++) {
				aArr[Integer.parseInt(A[i])]++;
			}
			
			
			/*1. b라는 애의 카드를 배열로 넣는다.*/
			String[] B= br.readLine().split(" ");
			//카드의 총 개수 
			int bCount=Integer.parseInt(B[0]);
			
			int[] bArr=new int[5];
			//순서대로 넣어주기 
			for(int i=1;i<=bCount;i++) {
				bArr[Integer.parseInt(B[i])]++;
			}
			
			
			//뒤에서부터 비교해주면 끝
			for(int i=4;i>=0;i--) {
				//0번쨰가 된 것은 결국 전부 같다는 뜻이므로 D를 출력하고 종료 
				if(i==0) {
					System.out.println("D");
				}
				
				
				if(aArr[i]>bArr[i]) {
					System.out.println("A");
					break;
				}else if(aArr[i]<bArr[i]){
					System.out.println("B");
					break;
				}else {
					continue;
				}
			}
		}
		
	}
}
