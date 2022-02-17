import java.util.Scanner;

public class BOJ_2477_참외밭 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int field[][] = new int[6 + 2][6];

		int K = sc.nextInt(); // 1m^2에 자라는 참외 개수
		// 동쪽 1, 서쪽 2, 남쪽 3, 북쪽 4, 반시계방향
		// 6각형이니까 6번 입력
		for (int i = 1; i <= 6; i++) {
			field[i][0] = sc.nextInt(); // 방향
			field[i][1] = sc.nextInt(); // 길이
		}

		// index error, 배열 끝 이어주기, 앞뒤로
		field[7][0] = field[1][0];
		field[7][1] = field[1][1];
		field[0][0] = field[6][0];
		field[0][1] = field[6][1];

		int big = 0;
		int small = 0;
		int east = 0;
		int south = 0;

		// 큰 네모 넓이 구하기
		for (int i = 1; i <= 6; i++) {
			if (field[i][0] == 1 || field[i][0] == 2) { // 동쪽최대길이
				east = Math.max(east, field[i][1]);
			}
		if (field[i][0] == 3 || field[i][0] == 4) { // 남쪽 대길이
				south = Math.max(south, field[i][1]);
			}
		}
		big = east * south; // 곱하기

		int row = 0;
		int col = 0;
		// 작은 네모 넓이 구하기
		for (int i = 1; i < 7; i++) {
			if (field[i][0] == 1 || field[i][0] == 2) {
				if (field[i - 1][1] + field[i + 1][1] == south) {
					row = field[i][1];
				}
			}
			if (field[i][0] == 3 || field[i][0] == 4) {
				if (field[i - 1][1] + field[i + 1][1] == east) {
					col = field[i][1];
				}
			}
		}
		small = row * col;

		System.out.println(K * (big - small));

	}

}
