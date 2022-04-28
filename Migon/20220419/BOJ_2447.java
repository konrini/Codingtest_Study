import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static String[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 크기
		int N = Integer.parseInt(br.readLine());
		// 별 찍을 배열
		arr = new String[N][N];
		star(0, 0, N, false);
		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.write(arr[i][j]);
			}
			bw.write("\n");
		}
		bw.close();
	}

	// 행 좌표, 열 좌표, 크기, 빈칸 여부
	public static void star(int r, int c, int size, boolean blank) {
		// 빈칸을 위한 자리일 때
		if (blank) {
			for (int i = r; i < r + size; i++) {
				for (int j = c; j < c + size; j++) {
					arr[i][j] = " ";
				}
			}
			return;
		}
		// 더 이상 나눠지지 않을 때 별 찍기
		if (size == 1) {
			arr[r][c] = "*";
			return;
		}
		// 가운데 빈칸을 위한 카운트
		int count = 0;
		for (int i = r; i < r + size; i += size / 3) {
			for (int j = c; j < c + size; j += size / 3) {
				count++;
				// 가운데일 때
				if (count == 5) {
					star(i, j, size / 3, true);
				} else {
					star(i, j, size / 3, false);
				}
			}
		}
	}
}
