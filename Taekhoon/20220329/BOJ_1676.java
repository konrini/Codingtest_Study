package boj.class2;

import java.util.Scanner;

public class BOJ_1676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 소인수분해(?)해서 2와 5가 각각 몇 개씩 있는지 체크
		int num2Cnt = 0; // 2의 개수
		int num5Cnt = 0; // 5의 개수
		
		// 1~N까지의 수를 돌면서 각각의 수가 2,5가 몇 개씩 들어있는지 확인
		for (int i = 1; i <= N; i++) {
			int num = i;
			while(num % 2 == 0) {
				++num2Cnt;
				num /= 2;
			}
			while( num % 5 == 0) {
				++num5Cnt;
				num /= 5;
			}
		}
		// 2와 5의 짝이 맞아야 10이 되므로 작은 수를 출력
		System.out.println((num2Cnt >= num5Cnt) ? num5Cnt : num2Cnt);
	}
}
