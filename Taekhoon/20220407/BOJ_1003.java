package boj.class3;

import java.util.Scanner;

public class BOJ_1003 {
	static int[][] cnt;
	public static void main(String[] args) {
		
		// 0과 1의 횟수도 피보나치임을 찍어보고 알았음
		// 메모이제이션으로 0과 1의 횟수를 각각 피보나치로 구함
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int n = sc.nextInt();
			cnt = new int[41][2];

			cnt[0][0] = 1;
			cnt[1][0] = 0;

			cnt[0][1] = 0;
			cnt[1][1] = 1;

			System.out.println(f0(n) + " " + f1(n));

		}
	}

	static int f0(int n) {
		if (n <= 1) {
			return cnt[n][0];
		} else if (cnt[n][0] != 0) {
			return cnt[n][0];
		} else {
			return cnt[n][0] = f0(n - 1) + f0(n - 2);
		}
	}

	static int f1(int n) {
		if (n <= 1) {
			return cnt[n][1];
		} else if (cnt[n][1] != 0) {
			return cnt[n][1];
		} else {
			return cnt[n][1] = f1(n - 1) + f1(n - 2);
		}
	}
}
