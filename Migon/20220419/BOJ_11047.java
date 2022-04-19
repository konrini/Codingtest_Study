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
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 동전 종류의 개수
		int N = Integer.parseInt(st.nextToken());
		// 가치의 합
		int K = Integer.parseInt(st.nextToken());
		// 동전 종류 (내림차순)
		int[] coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[N - 1 - i] = Integer.parseInt(br.readLine());
		}
		// 동전의 개수
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			// 만약 나눠지면
			if (coins[i] <= K) {
				// 몫 더하고
				cnt += K / coins[i];
				// 나머지로 만들어
				K %= coins[i];
			}
		}
		bw.write(cnt + "");
		bw.close();
	}
}