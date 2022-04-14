package boj.class3;

import java.util.Scanner;

public class BOJ_9095_123더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <=T; tc++) {
			int n = sc.nextInt();
			int[] arr = new int[12];
			arr[1] = 1;
			arr[2] = 2;
			arr[3] = 4;
			
			for(int i = 4; i <=n;i++) {
				arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
			}
			
			System.out.println(arr[n]);
		} //tc
	} // main
}
