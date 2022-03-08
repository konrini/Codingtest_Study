package boj.class2;

import java.util.Scanner;

public class BOJ_1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int ans = N; // 전부 소수라고 가정
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(num == 1) { // 1은 소수가 아니므로 정답에서 1 빼기
				ans--;
			} else if(num == 2) { // 짝수 중 2만 소수이므로 숫자가 2이면 다음 수 조사
				continue;
			} else if(num % 2== 0) { // 숫자가 짝수라면 정답에서 1 빼기
				ans--;
			} else { // 1도 아니고 2도 아니고 짝수도 아니면 3부터 나누어떨어지면 정답에서 1 빼기
				for(int j = 3; j < num;j++) {
					if(num % j == 0) {
						ans--;
						break;
					}
				}
			}
			
		}
		System.out.println(ans);
	}
}
