import java.util.Scanner;

public class BOJ_11659_구간합구하기4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//수 N개, 1~100000
		int N = sc.nextInt();
		//합을 구해야 하는 횟수, 1~100000
		int M = sc.nextInt();
		
		//누적 합을 저장해 둘 배열 
		int sum[] = new int[N];
		for(int i=0; i<N; i++) {
			if(i==0)
				sum[i] = sc.nextInt();
			else
				sum[i] = sum[i-1] + sc.nextInt();
		}
		
		for(int tc=0; tc<M; tc++) {
			//i~j번째 수까지 합을 구하기, idx 맞춰주기
			int i = sc.nextInt()-1;
			int j = sc.nextInt()-1;
			
			//i가 0이면 처음부터 더하니까 안 빼줘도 됨
			if(i==0)
				System.out.println(sum[j]);
			else
				System.out.println(sum[j]-sum[i-1]);
			
		}//test case
		
	}

}
