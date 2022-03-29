package com.boj.day20220329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1676_팩토리얼 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		
		
		
		int result=0;
		
		//5! 밑은 어차피 0 없음 
		if(num<5) {
			
			//딱히 필요한 코드는 없다 
		
			
		//그 이외에서는 소인수분해를 통해서 2의 개수와 5의 개수 중 최소값으로 가면 된다!
		}else {
			
			//2의 소인수 개수를 전부 더해두기 
			int twoCnt=0;
			//5의 소인수 개수를 전부 더해두기 
			int fiveCnt=0;
			
			for(int i=1;i<=num;i++) {
				
				int temp=i;
				//2의 배수 찾기
				
				while(temp%2==0) {
					
					temp/=2;
					twoCnt++;
					
				}
				
				
				while(temp%5==0) {
					
					temp/=5;
					fiveCnt++;
					
				}
				
				
				
			}
			
			result=Math.min(twoCnt, fiveCnt);
			
		}
		
		
		System.out.println(result);
		
	}
}