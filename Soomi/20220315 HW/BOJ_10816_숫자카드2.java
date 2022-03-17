import java.util.Scanner;

public class BOJ_10816_숫자카드2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		//상근이 숫자 카드 N개 보유 중
		int N = sc.nextInt();
		//음수도 천만개, 0도 있음
		int[] num = new int[20000001];
		
		for (int i = 0; i < N; i++) {
			//있으면 ++
			num[sc.nextInt()+10000000] += 1;
		}
		
		//M 숫자 몇 개 가지고 있는지 확인
		int M = sc.nextInt();
		
		for (int i = 0; i < M; i++) {
		//상근이가 M개 수 각각 몇 개씩 가지고 있는지 저장			
		//인덱스 옮겨서 있으면 출력
			sb.append(num[sc.nextInt()+10000000]).append(" ");
		}
		
		//end input
		
		System.out.println(sb);
		
	}

}
