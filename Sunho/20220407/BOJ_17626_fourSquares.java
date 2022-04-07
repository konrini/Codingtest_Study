package com.boj.day20220407;

import java.util.Scanner;

public class BOJ_17626_fourSquares {
	
	static int num,max;
	static int[] sel;
	static boolean result=false;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		num=sc.nextInt();
		
		max=(int)Math.sqrt(num);
		
		for(int i=1;i<=4;i++) {
			//라그랑주 특성상 어차피 4개에서 끝나기 때문에, 4까지 오면 무조건 4이다. 
			if(i==4) {
				System.out.println(4);
				break;
			}
			
			
			sel=new int[i];
			comb(max,0,0);
			
			if(result) {
				System.out.println(i);
				break;
			}
		}
	}
	//                       넣을숫자    채워줄 인덱스    합 
	private static void comb(int cnt, int idx   ,int sum) {
		
		
		if(idx==sel.length) {
			
			if(sum==num) {
				result=true;
			}
			return;
		}
		
		//다 돌았는데 다 안채워지고  끝난 형태 
		if(cnt<0) {
			return;
		}
		
		
		
		//안넣어준거 
		comb(cnt-1,idx,sum);
		
		//넣어준거 
		sel[idx]=cnt;
		
		sum+=cnt*cnt;
		
		//중복때문에 필요
		//남은 sum이 더 낮으면 이번cnt를 중복으로 볼 필요가 없다 
		if(sum<cnt*cnt) {
			comb(cnt-1,idx+1,sum);
		
		//지금 sum이 더 들어갈 수도 있기 때문에, 줄이지 않고 한번 더 간다. 대신 넣어주는 sel의 idx만 하나 늘려주고 진행한다.
		}else {
			comb(cnt,idx+1,sum);
		}
		
		
		
		
	}
	
	
}
