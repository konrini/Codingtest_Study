package boj.class3;

import java.util.Scanner;

public class BOJ_1002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();

			// r2를 무조건 큰 값으로 생각하기 위함
			if (r1 > r2) {
				int temp = r2;
				r2 = r1;
				r1 = temp;
			}

			// 조씨와 백씨 사이의 거리
			double d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

			// 두 반지름의 길이가 같은 경우
			if (r1 == r2) {
				if (d == 0) { // 두 원이 완전히 겹치는 경우
					System.out.println(-1);
				} else if (d > r1 + r2) { // 두 원이 안 만나는 경우
					System.out.println(0);
				} else if (d == r1 + r2) { // 두 원이 한 점에서 만나는 경우
					System.out.println(1);
				} else { // 두 원이 두 점에서 만나는 경우
					System.out.println(2);
				}
			} else { // 두 반지름의 길이가 다른 경우(r2> r1)
				if( r2 > r1 + d) { // 큰 원 안에 작은 원이 있고 안 만나는 경우
					System.out.println(0);
				} else if( r2 == r1+d) { // 큰 원 안에 작은 원이 있고 한 점에서 만나는 경우
					System.out.println(1);
				} else if (d > r1 + r2) { // 안 만나는 경우
					System.out.println(0);
				} else if ( d == r1 + r2) { // 한 점에서 만나는 경우
					System.out.println(1);
				} else if( d == 0) { // 두 원의 중심이 같은 경우 => 안 만남
					System.out.println(0);
				} else { // 두 점에서 만나는 경우
					System.out.println(2);
				}
			}

		}

	}

}
