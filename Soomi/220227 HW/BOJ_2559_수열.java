import java.util.Scanner;

public class BOJ_2559_수열 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 온도 측정한 전체 날짜 수
		int K = sc.nextInt(); // 합 구하기 위한 연속적인 날짜 수

		int[] degree = new int[N];
		for (int i = 0; i < N; i++) {
			degree[i] = sc.nextInt();
		}

		int max = Integer.MIN_VALUE;   //가장 작은 수로 초기화
		for (int i = 0; i < N - K + 1; i++) {
			int sum = 0;
			for (int j = i; j < i+K; j++) {
				sum += degree[j];
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}

}
