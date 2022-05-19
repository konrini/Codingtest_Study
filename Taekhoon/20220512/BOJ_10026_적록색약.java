package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {
	static int N; // 크기
	static char[][] pic; // 그림
	static char[][] pic2; // 적록색약이 보는 그림
	static boolean[][] visited; // 방문처리용
	static int cnt; // 구역 수

	// 상하좌우 4방 탐색
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pic = new char[N][N];
		for (int i = 0; i < N; i++) {
			pic[i] = br.readLine().toCharArray();
		}
		StringBuilder sb = new StringBuilder();
		cnt = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					++cnt;
					char color = pic[i][j];
//					System.out.println("i: " + i + " j: " + j);
					dfs(i, j, color);
				}
			}
		}
		sb.append(cnt).append(" ");
//		System.out.println("적록색약X: " + cnt);

		cnt = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (pic[i][j] != 'B') {
					pic[i][j] = 'R';
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					++cnt;
					char color = pic[i][j];
//					System.out.println("i: " + i + " j: " + j);
					dfs(i, j, color);
				}
			}
		}
		sb.append(cnt);
//		System.out.println("적록색약O: " + cnt);

		
		System.out.println(sb);
	}

	// 적록색약이 아닌 사람이 봤을 때의 구역
	static void dfs(int row, int col, char color) {
		visited[row][col] = true;
		if (pic[row][col] != color) {
			return;
		} else {
			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc] && pic[nr][nc] == color) {
//					System.out.println("nr: " + nr + " nc " + nc);
					dfs(nr, nc, color);
				}
			}
		}

	}


}
