package boj.class3;

import java.util.Scanner;

public class BOJ_1463_1로만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] dp = new int[1000001];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		// 대전제,,,, 경우를 나누기 했는데 왜 이렇게 나누면 답이 나오는지를 모르곘음... 운으로 맞춤 
		// 예를 들어 dp[12]를 구할때 
		// 1. dp[4] + 1
		// 2. dp[6] + 1
		// 3. dp[11] + 1
		// 4. dp[10] + 2 등
		// 여러가지 경우를 다 봐야할 거 같은데 왜 답이 나오지,.....
		
		for(int i = 4; i <= N;i++) {
			// 3을 기준으로 숫자 나눔
			if(i % 3 == 0) { // 3으로 나누어 떨어질 때
				if( i % 2 == 0) { // 짝수인 경우
					dp[i] = Math.min(dp[i/2] + 1, dp[i/3] + 1);
				} else { // 홀수인 경우
					dp[i] = Math.min(dp[i-1] + 1, dp[i/3] + 1);
				}
			} else if ( i % 3 == 1) { // 3으로 나눈 나머지가 1인 경우
				if( i % 2 == 0) {
					dp[i] = Math.min(dp[i/2] + 1, dp[i-1] + 1);
				} else {
					dp[i] = dp[i-1] + 1;
				}
			} else {
				if( i % 2 == 0) { // 3으로 나눈 나머지가 2인 경우
					dp[i] = Math.min(dp[i/2] + 1, dp[i-1] + 1);
				} else {
					dp[i] = dp[i-1] + 1;
				}
			}
		}
//		for (int i = 0; i < dp.length; i++) {
//			System.out.println(i + ": " + dp[i]);
//		}

		System.out.println(dp[N]);

	}
}
