import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 색종이의 수
		int N = Integer.parseInt(br.readLine());
		// 흰색 도화지
		int[][] board = new int[100][100];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 시작 x 좌표
			int v = Integer.parseInt(st.nextToken());
			// 시작 y 좌표
			int h = Integer.parseInt(st.nextToken());
			// 가로의 크기
			int max_v = v + 10 > 100 ? 100 : v + 10;
			// 세로의 크기
			int max_h = h + 10 > 100 ? 100 : h + 10;
			// 면적 체크
			for (int a = v; a < max_v; ++a) {
				for (int b = h; b < max_h; ++b) {
					++board[a][b];
				}
			}
		}
		// 검은 영역의 넓이
		int ans = 0;
		for (int r = 0; r < 100; ++r) {
			for (int c = 0; c < 100; ++c) {
				if (board[r][c] != 0) {
					++ans;
				}
			}
		}
		bw.write(ans + "");
		bw.close();
	}
}