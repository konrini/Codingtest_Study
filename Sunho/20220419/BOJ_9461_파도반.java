package com.boj.day20220419;

import java.util.Scanner;

public class BOJ_9461_파도반 {
	static long[] sample= {1,1,1,2,2};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		
		int[] ans= new int[T];
		//내가 넣을 인덱스  중 가장 큰 값. 이걸 기준으로 dp배열을 만들자!
		int maxNum=0;
		for(int tc=0;tc<T;tc++) {
			ans[tc]=sc.nextInt()-1;
			maxNum=Math.max(maxNum, ans[tc]);
		}
		
		
		StringBuilder sb = new StringBuilder();
		//가장 큰 인덱스가 4이하라면 dp를 갈 필요가 없다. 그렇기 때문에 위에 미리 선언해둔 sample을 통해서 처리하면 끝! 
		if(maxNum<5) {
			
			for(int i=0;i<ans.length;i++) {
				sb.append(sample[ans[i]]).append("\n");
			}
			
		//5이상이면 규칙을 통한 dp처리를 하자
		}else {
			
			long[] arr = new long[maxNum+1];
			for(int i=0;i<5;i++) {
				arr[i]=sample[i];
			}
			
			int cnt=5;
			while(cnt<=maxNum) {
				arr[cnt]=arr[cnt-1]+arr[cnt-5];
				cnt++;
			}
			
			for(int i=0;i<ans.length;i++) {
				sb.append(arr[ans[i]]).append("\n");
			}
			

			
		}
		
		System.out.println(sb.toString());
		
		
	}
}
