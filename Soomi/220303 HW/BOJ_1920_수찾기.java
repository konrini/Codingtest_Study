import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1920_수찾기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//하나씩 검색하면 시간 초과...
		
		int N = sc.nextInt();
		int[] A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		Arrays.sort(A);
		
		int M = sc.nextInt();
		
		for (int i = 0; i < M; i++) {
			int m = sc.nextInt();
			int left =0;
			int right = N-1;
			int ans = 0;
			
			while(left<=right) {
				int idx = (left+right) /2;
				int mid = A[idx];
				
				if(m==mid) {
					ans =1;
					break;
				}else if(m<mid) {
					right = idx-1;
				}else {
					//M>mid
					left = idx+1;
				}
				
			}
			System.out.println(ans);
			
		}
		
		
	}

}
