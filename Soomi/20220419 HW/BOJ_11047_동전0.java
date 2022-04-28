import java.util.Scanner;

public class BOJ_11047_동전0 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//동전 종류, 1~10
		int N = sc.nextInt();
		int []coins = new int[N];
		//합
		int K = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			coins[i] = sc.nextInt();
		}
		
		int ans = 0;
		
		for(int i=N-1; i>=0; i--) {
			if(coins[i]<=K) {
				ans+= K / coins[i];
				K %= coins[i];
			}
		}
		
		System.out.println(ans);
		
	}//main
}
