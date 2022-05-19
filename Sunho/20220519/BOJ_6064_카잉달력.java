package com.boj.day20220519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_6064_카잉달력 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++) {
			
			String[] str = br.readLine().split(" ");
			
			int M=Integer.parseInt(str[0]);
			
			int N=Integer.parseInt(str[1]);
			
			int remainM=Integer.parseInt(str[2])-1;
			int remainN=Integer.parseInt(str[3])-1;
			
			int maxMul=Math.max(M, N);
			
			int result;
			
			if(M>N) {
				result=remainM;
			}else {
				result=remainN;
			}
			
			
//			result<lcm(M,N)
			
			
			while(true) {
				//나머지가 우리 원한게 나오면 끝!
				if(result%M==remainM && result%N==remainN ) {
					break;
				}
				
				//최소공배수를 넘어가고,    결과는 한바퀴는 돌자! 
				if(result>lcm(M,N) && result>maxMul) {
					result=-2;
					break;
				}
				
				result+=maxMul;
				
			}
			sb.append(result+1).append("\n");
		}
		
		System.out.println(sb);
		
		
	}

	private static int lcm(int m, int n) {
		
		int a = m, b = n;
        
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        
        return m * n / a;
		
	}

	
	
}
