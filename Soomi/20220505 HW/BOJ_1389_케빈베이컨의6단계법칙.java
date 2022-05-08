import java.util.Scanner;

public class BOJ_1389_케빈베이컨의6단계법칙 {

	public static int friends[][], ans[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// User, 2~100
		int N = sc.nextInt();
		// relationship, 1~5000
		int M = sc.nextInt();

		friends = new int[N + 1][N + 1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j)
					friends[i][j] = 0;
				else
					friends[i][j] = 987654321;
			}
		}

		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			friends[A][B] = 1;
			friends[B][A] = 1;
		} // input

		// floyd
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					friends[i][j] = Math.min(friends[i][k] + friends[k][j], friends[i][j]);
				}
			}
		}

		ans = new int[N + 1];
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += friends[i][j];
			}
			ans[i] = sum;
			if(sum<min)
				min = sum;
		}

		for (int i = 1; i <= N; i++) {
			if (ans[i] == min) {
				System.out.println(i);
				break;
			}
		}

	}// main

}
