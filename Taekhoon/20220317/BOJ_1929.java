package boj.class2;

import java.util.Scanner;

public class BOJ_1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int num = start; num <= end; num++) {
			if(num == 1) continue; // 1은 소수가 아니므로 패스
			int cnt = 0; // 나누어 떨어지는 수의 개수
			int k = 1; // 나누어보는 수
			while( k <= Math.sqrt(num)) { // 루트까지만 계산해도 됨
				if(num % k++ == 0) { // k로 나누어 떨어지면 cnt 올림
					cnt++;
					if(cnt == 2) { // 나누어떨어지는 수가 2개가 되면 그 수는 소수가 아님
						break;
					}
				}
			}
			if( cnt == 1) { // 루트까지 다 돌았는데 나누어 떨어지는 수가 하나만 있으면 소수
				sb.append(num).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
