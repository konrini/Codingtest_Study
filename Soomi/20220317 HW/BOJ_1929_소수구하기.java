import java.util.Scanner;

public class BOJ_1929_소수구하기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean [] prime = new boolean [N+1];
		
		for(int i =2; i<= Math.sqrt(N); i++) {
			for (int j = 2; i*j <= N ; j++) {
				prime[i*j] = true;
			}
		}
		
		for(int i =M; i<=N; i++) {
			
			if(i==1) {
				continue;
			}
			
			if(!prime[i]) {
				System.out.println(i);
			}
		}
	}
}
