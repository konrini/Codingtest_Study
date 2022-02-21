import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 총 학생 수
		int N = Integer.parseInt(st.nextToken());
		// 한 방에 배정할 수 있는 최대 인원 수
		int K = Integer.parseInt(st.nextToken());
		// 학년별 인원 수
		int[][] grade = new int[6][2];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			// 성별과 학년별로 인원 수 세기
			int gender = Integer.parseInt(st1.nextToken());
			++grade[Integer.parseInt(st1.nextToken()) - 1][gender];
		}
		// 방 개수
		int ans = 0;
		for (int a = 0; a < 6; ++a) {
			for (int b = 0; b < 2; ++b) {
				if (grade[a][b] > 0) {
					if (grade[a][b] % K == 0) {
						ans += grade[a][b] / K;
					} else {
						ans += grade[a][b] / K + 1;
					}
				}
			}
		}
		// 출력
		sb.append(ans);
		System.out.println(sb);
	}
}