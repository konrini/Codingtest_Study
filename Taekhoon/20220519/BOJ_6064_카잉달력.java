package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064_카잉달력 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
//			int left = 0;
//			int right = 0;
//			int cnt = 0;
//			for(int i = 0 ; i < lcm(M,N); i++) {
//				++left;
//				++right;
//				++cnt;
//				StringBuilder sb = new StringBuilder();
//				sb.append("<");
//				 if(left > M) {
//					 left = 1;
//				 }
//				 if(right > N) {
//					 right = 1;
//				 }
//				 if(left == x) {
//					 sb.append(left).append(" : ").append(right).append(">");
//					 sb.append(" " + cnt);
//					 System.out.println(sb);
//					 
//				 }
//			}

			boolean flag = true;
			long maxYear = lcm(M, N);
			for (int year = x-1; year <= maxYear; year += M) {
				if (year % N == y-1) {
					System.out.println(year+1);
					flag = false;
					break;
				}
			}

			if (flag) {
				System.out.println(-1);
			}

		}
	}

	static long lcm(int num1, int num2) {
		long multiple = num1 * num2;
		// num1을 큰 수로 맞춰줌
		if (num2 > num1) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		// 일단 두 수의 최대 공약수
		while (num2 != 0) {
			int r = num1 % num2;
			num1 = num2;
			num2 = r;
		}
		int gcd = num1;

		return multiple / gcd;

	}

}
