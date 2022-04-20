import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11399_ATM {
	//재귀 아니야...오래걸려
	public static void main(String[] args) {
		//인출 시간의 최소값 구하기
		Scanner sc = new Scanner(System.in);
		
		//사람 수, 1~1000
		int N = sc.nextInt();
		//인출 시간
		int wdtime[] = new int[N];
		for(int i=0; i<N; i++) {
			wdtime[i] = sc.nextInt();
		}
		
		//오름차순이면 제일 조금 기다림
		Arrays.sort(wdtime);
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			//첫번째 사람은 안기다리고, 마지막 사람은 N-1번 기다림
			ans += wdtime[i] * (N-i);
		}
		
		System.out.println(ans);
		
	}//main

}
