import java.util.Scanner;

public class BOJ_2527_직사각형 {
	public static int x1, y1, p1, q1, x2, y2, p2, q2;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 4번 반복
		for (int i = 0; i < 4; i++) {
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			p1 = sc.nextInt();
			q1 = sc.nextInt();

			x2 = sc.nextInt();
			y2 = sc.nextInt();
			p2 = sc.nextInt();
			q2 = sc.nextInt();

			overlap();

		} // 4번 반복 끝

	}// main 끝

	public static void overlap() {

		// 점이 겹칠 때
		if ((p1 == x2 && q1 == y2) || (x1 == p2 && y1 == q2)
		 || (p1 == x2 && y1 == q2) || (x1 == p2 && q1 == y2)) {
			System.out.println("c");
			return;
			} // 안 겹칠 때
		else if (p1 < x2 || p2 < x1 || q2 < y1 || q1 < y2) {
			System.out.println("d");
			return;
		}
		// 선이 겹칠 때
		else if ((y1 == q2) || (q1==y2) || (p1==x2) || (x1==p2)) {
			System.out.println("b");
			return;
		} else
			System.out.println("a");

	}// end overlap

}