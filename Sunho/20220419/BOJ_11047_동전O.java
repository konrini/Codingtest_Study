package com.boj.day20220419;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_11047_동전O {
	static int N,K,min;
	static List<Integer> mList;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		K=sc.nextInt();
		min=Integer.MAX_VALUE;
		
		mList= new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			int num=sc.nextInt();
			if(num<=K) {
				mList.add(num);
			//어차피 가격 오버하면 끝!	
			}else {
				break;
			}
		}
		
		
		
		
		counting(mList.size()-1,K,0);
		
		System.out.println(min);
		
		
	}
	//						현재 동전 인덱스/  액수 총합 /   개수총합 
	private static void counting(int idx, int sum, int cntSum) {
		if(sum==0) {
			min=Math.min(min, cntSum);
			return;
		}
		
		//총합오버 /인덱스오버 /개수오버 
		if(idx<0||cntSum>min) {
			return;
		}
		
		
		//큰 액수부터 뒤로 오기 
		int num=mList.get(idx);
		//총 몇개가 들어가는지 확인

		cntSum+=(sum/num);
		counting(idx-1,sum%num,cntSum);
		
		
	}
}
