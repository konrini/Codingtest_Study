import java.util.Scanner;

public class BOJ_2564_경비원 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt(); // 가로
		int H = sc.nextInt(); // 세로

		int N = sc.nextInt(); // 상점 개수

		int[][] store = new int[N][2];

		for (int n = 0; n < N; n++) {
			int d = sc.nextInt(); // 상점 방향 1:북, 2: 남, 3:서, 4:동
			int l = sc.nextInt(); // 상점 거리

			store[n][0] = d;
			store[n][1] = l;
		}

		int x = sc.nextInt(); // 동근이 방향
		int y = sc.nextInt(); // 동근이 거리

		int ans = 0;

		for (int n = 0; n < N; n++) {

			int sum = Integer.MAX_VALUE;

			// 1. 동근이랑 상점이 같은 방향
			if (x == store[n][0]) {
				sum = Math.abs(y - store[n][1]);
			} // 2. 동근이랑 상점이 맞은편에 있을 때 - 북/남
			else if ((x == 1 && store[n][0] == 2) || (x == 2 && store[n][0] == 1)) {
				sum = Math.min(y + H + store[n][1], (W - y) + H + (W - store[n][1]));

			} // 2. 동근이랑 상점이 맞은편에 있을 때 - 서/동
			else if ((x == 3 && store[n][0] == 4) || (x == 4 && store[n][0] == 3)) {
				sum = Math.min(y + W + store[n][1], (H - y) + W + (H - store[n][1]));
			} // 3. 동근이랑 상점이 옆에 있을 때 - 북/남
			else if (x == 1 || x == 2) {
				int a = x == 1 ? store[n][1] : (H - store[n][1]);
				if (store[n][0] == 3) {
					sum = y + a;
				} else {
					sum = (W - y) + a;
				}
			} // 3. 동근이랑 상점이 옆에 있을 때 - 서/동
			else {
				int a = x == 3 ? store[n][1] : (W - store[n][1]);
				if (store[n][0] == 1) {
					sum = y + a;
				} else {
					sum = (H - y) + a;
				}
			}
			ans += sum;
			

		} // 상점 비교 끝

		System.out.println(ans);
	}// end main

}
