package boj.class2;

import java.util.Scanner;

public class BOJ_1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 비용의 최솟값
		int[][] price = new int[N+1][3];
		int[][] totalPrice = new int[N+1][3];
		for(int i = 1; i <= N;i++) {
			price[i][0] = sc.nextInt(); // i번째 집 빨강 비용
			price[i][1] = sc.nextInt(); // i번째 집 초록 비용
			price[i][2] = sc.nextInt(); // i번째 집 파랑 비용
			
		}
		
		// total[i][0]은 i번째 집에 빨강을 칠했을때의 최소 비용
		for(int i = 1; i<=N;i++) {
			totalPrice[i][0] = Math.min(totalPrice[i-1][1], totalPrice[i-1][2]) + price[i][0];
			totalPrice[i][1] = Math.min(totalPrice[i-1][2], totalPrice[i-1][0]) + price[i][1];
			totalPrice[i][2] = Math.min(totalPrice[i-1][0], totalPrice[i-1][1]) + price[i][2];
		}
		
		System.out.println(Math.min(totalPrice[N][2], Math.min(totalPrice[N][0], totalPrice[N][1])));
	}
}
