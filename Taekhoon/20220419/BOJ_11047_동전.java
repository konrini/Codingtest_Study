package boj.class3;

import java.util.Scanner;

public class BOJ_11047_동전 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] coin = new int[N];
		
		// dp라고 썻는게 이게 dp가 맞는지 모르겠음
		int[] priceDp = new int[K+1];
		
		// 동전 종류 입력 받기(개꿀조건이 1원짜리 무조건 있는거랑, 오름차순으로 입력 주는거랑, 배수관계인듯)
		for(int i = 0 ; i <N;i++) {
			coin[i] = sc.nextInt();
		}
		priceDp[1] = 1; // 1원 지불 방법은 1원짜리 1개 내는 경우
		
		
		// 2원 ~ K원 내는 방법까지 알아보기
		for(int i = 2; i<=K;i++) {
			
			priceDp[i] = priceDp[i-1] + 1; // i원 내는 방법 중 무조건 되는(?) 방법은 i-1원에서 1원 더 내는 경우
			
			// 가장 큰 단위부터 확인하기 
			for(int j = N-1; j >= 0; j--) {
				if(i-coin[j] >=0) { // i원에서 현재 내가 지불하고 싶은 단위를 뺐을 때 양수인 경우만 
					
					// 현재 dp[i]와 (i-coin[j])원에서 coin[j]원 1개 지불하는 방법 비교하고
					// 작은값을 priceDp에 저장
					priceDp[i] = Math.min(priceDp[i], priceDp[i-coin[j]] + 1);  
				}
			}
		}
		System.out.println(priceDp[K]);
	}
}
