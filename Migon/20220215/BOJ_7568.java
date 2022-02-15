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
		int N = Integer.parseInt(br.readLine());
		// 몸무게와 키 정보 받기
		int[][] info = new int[N][2];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		// 자신보다 덩치가 큰 사람 수를 센다.
		for (int j = 0; j < N; ++j) {
			int cnt = 1;
			for (int k = 0; k < N; ++k) {
				if (info[j][0] < info[k][0] && info[j][1] < info[k][1]) {
					++cnt;
				}
			}
			bw.write(cnt + " ");
		}
		bw.close();
	}
}