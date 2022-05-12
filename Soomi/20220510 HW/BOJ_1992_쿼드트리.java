import java.util.Scanner;

public class BOJ_1992_쿼드트리 {

	public static int N, Quad[][];
	public static StringBuilder sb;

	public static void main(String[] args) {

		// 흰 점: 0, 검은 점: 1, 4등분으로 압축
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();

		// 영상 크기, 2의 제곱수
		N = sc.nextInt();

		Quad = new int[N][N];
		for (int i = 0; i < N; i++) {

			String s = sc.next();

			for (int j = 0; j < N; j++) {
				Quad[i][j] = s.charAt(j) - '0';
			}
		} // input

		find(0, 0, N);

		System.out.println(sb);

	}// main

	public static void find(int x, int y, int size) {

		if (check(x, y, size)) {
			sb.append(Quad[x][y]);
			return;
		}

		sb.append("(");

		// 왼쪽 위
		find(x, y, size / 2);
		// 오른쪽 위
		find(x, y + size / 2, size / 2);
		// 왼쪽 아래
		find(x + size / 2, y, size / 2);
		// 오른쪽 아래
		find(x + size / 2, y + size / 2, size / 2);

		sb.append(")");

	}

	public static boolean check(int x, int y, int size) {
		int a = Quad[x][y];

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (Quad[i][j] != a)
					return false;
			}
		}

		return true;
	}
}
