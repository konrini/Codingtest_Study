import java.util.Scanner;

public class BOJ_1654_랜선자르기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// K개 랜선
		int K = sc.nextInt();
		int[] wire = new int[K];
		// 필요한 개수 N개
		int N = sc.nextInt();

		long max =0;
		
		// lan선 길이 입력
		for (int lan = 0; lan < K; lan++) {
			int l = sc.nextInt();
			wire[lan] = l;
			//가장 긴 선 찾기
			if(max<=l) {
				max = l;
			}
		}
		
		// 반으로 나누니까 하나 더 커야함
		max += 1;
		
		long min =0;
		long mid =0;
		long cnt =0;
		
		while(min<max) {
			
			// 초기화
			cnt =0;
			
			mid = (min + max) /2;
			
			// mid 길이만큼 몇 개 나오는지 저장
			for (int i = 0; i < K; i++) {
				cnt += wire[i] / mid;
			}
			
			// 필요한 것 보다 못 만들었으면 더 잘라야 함, 왼쪽 반 검사
			if(cnt < N) {
				max = mid;
			}else {
			// 만들었으면 최대 길이로 update, 오른쪽 반 검사
				min = mid +1;
			}
			
		}// end while
		
		// -1
		System.out.println(min-1);
		
		
	}

}
