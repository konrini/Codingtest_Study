package boj.class2;

import java.util.Scanner;

public class BOJ_2527 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			// 첫번째 직사각형
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			// 두번째 직사각형
			int m1 = sc.nextInt();
			int n1 = sc.nextInt();
			int m2 = sc.nextInt();
			int n2 = sc.nextInt();

			// 안만나는 경우!
			if (x1 > m2 || x2 < m1 || y1 > n2 || y2 < n1) {
				System.out.println("d");

				// 한점에서만 만나는 경우
			} else if ((x1 == m2 && y1 == n2) || (x2 == m1 && y2 == n1) || (x1 == m2 && y2 == n1)
					|| (x2 == m1 && y1 == n2)) {
				System.out.println("c");
				// 선분으로 만나는 경우
			} else if ((y1 == n2 && m1 < x2 && m2 > x1) || (y1 == n2 && x2 > m1 && x1 < m2)
					|| (y2 == n1 && m1 < x2 && m2 > x1) || (y2 == n1 && x2 > m1 && x1 < m2)
					|| (x1 == m2 && y1 < n2 && y2 > n1) || (x1 == m2 && y2 > n1 && y1 < n2)
					|| (x2 == m1 && y1 < n2 && y2 > n1) || (x1 == m2 && y2 > n1 && y1 < n2)) {
				System.out.println("b");

			} else {
				System.out.println("a");
			}

		}
	}
}
