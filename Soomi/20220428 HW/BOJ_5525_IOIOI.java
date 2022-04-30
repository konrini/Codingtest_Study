import java.util.Scanner;

public class BOJ_5525_IOIOI {

	public static int N, M, ans, repeat[];
	public static String []S;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		S = sc.next().split("");
		
		ans = 0;
		
		//OI 반복이 N만큼 되고, 맨 처음 I면 ans++
		//OI 반복 저장 배열
		repeat = new int[M];
		
		for(int i=1; i<M-1; i++) {
			if(S[i].charAt(0)=='O' && S[i+1].charAt(0)=='I') {
				repeat[i+1] = repeat[i-1] +1;
				
				if(repeat[i+1]>=N && S[i-2*N+1].charAt(0)=='I') {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}//main

}
