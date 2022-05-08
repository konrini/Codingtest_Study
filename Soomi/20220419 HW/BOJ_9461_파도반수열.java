import java.util.Scanner;

public class BOJ_9461_파도반수열 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			
			long dp[] = new long[100];
			
			dp[0] = 1;  dp[1] = 1;
			dp[2] = 1;  dp[3] = 2;
			dp[4] = 2;  dp[5] = 3;
			
			for(int j=6; j<100; j++) {
				dp[j] = dp[j-1] + dp[j-5];
			}
			
			
			int N = sc.nextInt();
			System.out.println(dp[N-1]);
		}
	}

}
