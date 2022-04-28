package boj.class3;

import java.util.Scanner;

public class BOJ_9461_파도반수열 {
	public static void main(String[] args) {
		long[] arr = new long[101];
		
		arr[1]  = 1;
		arr[2]  = 1;
		arr[3]  = 1;
		arr[4]  = 2;
		arr[5]  = 2;
		
		// 그냥 규칙이 보여서...
		// n번째 수는 n-5번째 값 + n-1번째 값이더라구..
		// 근데 이렇게 까지 숫자가 커질 줄을 몰랐어 int -> long
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T; tc++) {
			int N = sc.nextInt();
			
			for(int i = 6 ; i <= N;i++) {
				arr[i] = arr[i-5] + arr[i-1];
			}
			
			System.out.println(arr[N]);
		}
		
		
		
	}
}
