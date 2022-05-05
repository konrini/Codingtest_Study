import java.util.Scanner;

public class BOJ_11727_2xn타일링2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//1~1000
		int n = sc.nextInt();
		int dp[] = new int[n+1];
		
		//1번이랑 같은데, 2X2도 가능
		dp[0] = 1;
		dp[1] = 3;
		for(int i=2; i<=n; i++) {
			dp[i] = (dp[i-1] + 2*dp[i-2]) %10007;
		}
		
		System.out.println(dp[n-1]);
	}

}
