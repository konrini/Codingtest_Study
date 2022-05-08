package boj.class3;

import java.util.Scanner;

public class BOJ_5525_IOIOI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String S = sc.next();
		int cnt = 0; // 패턴이 몇 개 포함되어 있는지
		String pattern = makePattern(N);
		// 0번부터 차례대로 돌면서 패턴이 있으면 cnt 1 증가
		for(int i = 0; i < M - pattern.length() + 1; i++) {
			if(S.substring(i, i+pattern.length()).equals(pattern)) {
				++cnt;
			}
		}
		// 출력
		System.out.println(cnt);
	}

	
	// 비교할 패턴만드는 함수
	private static String makePattern(int n) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n * 2 + 1;i++) {
			if(i % 2 == 0) {
				sb.append("I");
			}
			else {
				sb.append("O");
			}
		}
		String result = sb.toString();
		return result;
	}
}
