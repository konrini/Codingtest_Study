package boj.class2;

import java.util.Scanner;

public class BOJ_11726 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] nums = new int[n+1];
		nums[1] = 1;
		if(n>=2) {
			nums[2] = 2;
		}
		for (int i = 3; i <= n; i++) {
			nums[i] = (nums[i - 1] + nums[i - 2]) % 10007;
		}
		System.out.println(nums[n]);
	}
}
