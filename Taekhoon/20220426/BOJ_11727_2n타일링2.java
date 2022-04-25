package boj.class3;

import java.util.Scanner;

public class BOJ_11727_2n타일링2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] nums = new int[n+1];
		// n =2 일때까진 그냥 그려봄 
		// 2까지하는 이유는 i번째를 할려면 i-1, i-2가 필요해서
		nums[1] = 1;
		if(n>=2) {
			nums[2] = 3;
		}
		
		// i를 만드는 방법
		// 1. i-1번째에 1*2짜리 타일 1개 붙이기
		// 2. i-2번째에 2*1짜리 타일 2개 붙이기
		// 3. i-2번째에 2*2짜리 타일 2개 붙이기
		for (int i = 3; i <= n; i++) {
			nums[i] = (nums[i - 1] + nums[i - 2] * 2) % 10007;
		}
		System.out.println(nums[n]);
	}
}
