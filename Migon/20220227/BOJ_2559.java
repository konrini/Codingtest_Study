import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		// 온도를 측정한 전체 날짜의 수
		int N = Integer.parseInt(st1.nextToken());
		// 연속적인 날짜의 수
		int K = Integer.parseInt(st1.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st2.nextToken());
		}
		// 온도의 합의 최대
		int max = 0;
		// 연속 K일의 온도의 합
		int sum = 0;
		for (int i = 0; i < K; ++i) {
			sum += numbers[i];
		}
		max = sum;
		// 한 칸씩 이동하며 비교
		for (int i = 0; i < N - K; ++i) {
			sum -= numbers[i];
			sum += numbers[i + K];
			if (sum > max) {
				max = sum;
			}
		}
		System.out.println(max);
	}
}