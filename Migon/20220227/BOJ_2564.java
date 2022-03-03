import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		// 블록의 가로의 길이와 세로의 길이
		int c = Integer.parseInt(st1.nextToken());
		int r = Integer.parseInt(st1.nextToken());
		// 상점의 개수
		int N = Integer.parseInt(br.readLine());
		// 상점의 위치와 동근이의 위치
		int[][] location = new int[N + 1][2];
		for (int i = 0; i < N + 1; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			// 좌표로 표현
			// 1 : 북, 2 : 남, 3 : 서, 4 : 동
			int temp_dir = Integer.parseInt(st2.nextToken());
			if (temp_dir == 1) {
				location[i][1] = r;
				location[i][0] = Integer.parseInt(st2.nextToken());
			} else if (temp_dir == 2) {
				location[i][1] = 0;
				location[i][0] = Integer.parseInt(st2.nextToken());
			} else if (temp_dir == 3) {
				location[i][0] = 0;
				location[i][1] = (r - Integer.parseInt(st2.nextToken()));
			} else {
				location[i][0] = c;
				location[i][1] = (r - Integer.parseInt(st2.nextToken()));
			}
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			// 남과 북에 위치
			if ((location[N][0] != 0 && location[N][1] == r && location[i][0] != 0 && location[i][1] == 0)
					|| (location[N][0] != 0 && location[N][1] == 0 && location[i][0] != 0 && location[i][1] == r))
				sum += Math.min(location[N][0] + location[i][0] + r, c - location[N][0] + c - location[i][0] + r);
			// 동과 서에 위치
			else if ((location[N][0] == 0 && location[N][1] != 0 && location[i][0] == c && location[i][1] != 0)
					|| (location[N][0] == c && location[N][1] != 0 && location[i][0] == 0 && location[i][1] != 0))
				sum += Math.min(location[N][1] + location[i][1] + c, r - location[N][1] + r - location[i][1] + c);
			// 인접
			else
				sum += Math.abs(location[N][0] - location[i][0]) + Math.abs(location[N][1] - location[i][1]);
		}
		System.out.println(sum);
	}
}