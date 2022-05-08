import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 테스트 케이스의 개수
		int T = Integer.parseInt(br.readLine());
		// 수열 값을 담은 배열
		long[] P = new long[101];
		P[1] = 1;
		P[2] = 1;
		P[3] = 1;
		P[4] = 2;
		P[5] = 2;
		for (int i = 0; i < T; i++) {
			// P(N)에서의 N값
			int N = Integer.parseInt(br.readLine());
			// 이미 값이 저장되어 있을 때
			if (P[N] != 0) {
				bw.write(P[N] + "\n");
				continue;
			}
			// 6번값부터 채워넣기
			for (int j = 6; j <= N; j++) {
				P[j] = P[j - 5] + P[j - 1];
			}
			bw.write(P[N] + "\n");
		}
		bw.close();
	}
}