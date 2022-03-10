package boj.class2;

import java.util.Scanner;

public class BOJ_1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 정수로 받고
		int ans = N; // 전부 한수라고 가정

		for (int num = 1; num <= N; num++) { // 1보다 크거나 같고 N보다 작거나 같은 수들 계산
			int len = (int) Math.log10(num) + 1; // num의 자리수 계산
			if (len <= 2) {
				continue; // num이 두 자리수 이하면 다음 수로~
			} else {
				int[] numChar = new int[len]; // num의 자리수 길이의 문자배열 선언
				// numchar을 num의 각 자리수로 초기화
				for(int i = 0 ; i< len; i++) {
					numChar[i] = Integer.toString(num).charAt(i) -'0';
				}
				// 등차계산
				int d = numChar[0] - numChar[1];
				// 각 자리수의 차를 계산
				for (int i = 1; i < len - 1; i++) {
					if (numChar[i] - numChar[i + 1] != d) { // 한수가 아니라면 ans에서 1 빼기
						ans--;
						break;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
