import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 면적당 참외의 개수
		int K = sc.nextInt();
		// 방향과 길이 정보
		int[][] info = new int[6][2];
		// 높이와 너비 최댓값
		int h_max = 0;
		int w_max = 0;
		for (int i = 0; i < 6; ++i) {
			int dir = sc.nextInt();
			info[i][0] = dir;
			int temp = sc.nextInt();
			info[i][1] = temp;
			if (dir == 1 || dir == 2) {
				if (temp > w_max) {
					w_max = temp;
				}
			} else if (dir == 3 || dir == 4) {
				if (temp > h_max) {
					h_max = temp;
				}
			}
		}
		// 빼야할 넓이
		int sub = 0;
		// 꺾일 때 방향이 a, b, a, b가 된다.
		// 그때 길이가 각 l, m, n, o라 하면 m*n의 넓이를 빼주면 된다.
		for (int j = 0; j < info.length; ++j) {
			if (info[j][0] == info[(j + 2) % 6][0] && info[(j + 1) % 6][0] == info[(j + 3) % 6][0]) {
				sub = info[(j + 1) % 6][1] * info[(j + 2) % 6][1];
				break;
			}
		}
		System.out.println(K * (h_max * w_max - sub));
	}
}
