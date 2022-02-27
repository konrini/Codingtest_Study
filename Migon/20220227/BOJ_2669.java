import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[100][100];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 왼쪽 아래 꼭짓점의 좌표와 오른쪽 위 꼭짓점의 좌표
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			for (int r = r1; r <= r2 - 1; r++) {
				for (int c = c1; c <= c2 - 1; c++) {
					map[r][c] = 1;
				}
			}
		}
		// 면적
		int sum = 0;
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map.length; c++) {
				sum += map[r][c];
			}
		}
		System.out.println(sum);
	}
}