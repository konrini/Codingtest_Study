package com.boj.day20220325;

import java.util.Scanner;

public class BOJ_11726_타일링 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		
		if(n==1) {
			System.out.println(1);
		}else if(n==2) {
			System.out.println(2);
		}else {
			int[] arr=new int[n+1];
			arr[1]=1;
			arr[2]=2;
			
			for(int i=3;i<=n;i++) {
				
				arr[i]=(arr[i-1]+arr[i-2])%10007;
				
			}
			
			System.out.println(arr[n]);
		}
		//이걸 옆으로 누워있는 작대기(1x2)로 생각하면 된다. 누워있는 경우 무조건 위아래 한세트로 있어야하기 때문에 세트로 세면 된다.
		
		
		
		
	}
}
