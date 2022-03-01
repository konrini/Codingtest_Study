import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 빙고판 만들기
		int[][] bingo = new int[5][5];
		for (int i = 0; i < bingo.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < bingo.length; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 사회자가 부르는 수
		int[] numbers = new int[25];
		for (int i = 0; i < bingo.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < bingo.length; j++) {
				numbers[i * 5 + j] = Integer.parseInt(st.nextToken());
			}
		}
		// 3줄 빙고 맞추기 전 최소 개수
		for (int i = 0; i < 11; i++) {
			search: for (int j = 0; j < bingo.length; j++) {
				for (int k = 0; k < bingo.length; k++) {
					if (bingo[j][k] == numbers[i]) {
						bingo[j][k] = 0;
						break search;
					}
				}
			}
		}
		// 숫자 지우면서 빙고 확인
		int ans = 1;
		for (int i = 11; i < numbers.length; i++) {
			search: for (int j = 0; j < bingo.length; j++) {
				for (int k = 0; k < bingo.length; k++) {
					if (bingo[j][k] == numbers[i]) {
						bingo[j][k] = 0;
						break search;
					}
				}
			}
			// 3줄 이상의 빙고인지
			if (bingo_cnt(bingo) >= 3) {
				ans += i;
				break;
			}
		}
		// 출력
		System.out.println(ans);
	}

	// 빙고 개수 반환하는 메서드
	public static int bingo_cnt(int[][] arr) {
		int cnt = 0;
		// 가로 빙고 검사
		for (int i = 0; i < arr.length; i++) {
			boolean check = true;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] != 0) {
					check = false;
					break;
				}
			}
			if (check)
				++cnt;
		}
		// 세로 빙고 검사
		for (int i = 0; i < arr.length; i++) {
			boolean check = true;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j][i] != 0) {
					check = false;
					break;
				}
			}
			if (check)
				++cnt;
		}
		// 대각선 빙고 검사1 (\)
		boolean check = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][i] != 0) {
				check = false;
				break;
			}
		}
		if (check)
			++cnt;
		// 대각선 빙고 검사2 (/)
		check = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[arr.length - 1 - i][i] != 0) {
				check = false;
				break;
			}
		}
		if (check)
			++cnt;
		return cnt;
	}
}