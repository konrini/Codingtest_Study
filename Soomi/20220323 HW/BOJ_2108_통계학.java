import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2108_통계학 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//N은 홀수
		int N = sc.nextInt();
		int [] num = new int[N];
		int sum =0;
		int midx = N/2;
		
		int[] cnt = new int[8001];

		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			num[i] = n;
			sum+= n;
			cnt[n+4000]++;
		}
		Arrays.sort(num);

		int most = num[0];
		int max = -1;		
		boolean b = false;
		
		for (int i = 0; i < 8001; i++) {
			if(cnt[i]==max) {
				b = true;
			}
			if(max<cnt[i]) {
				most = i-4000;
				max = cnt[i];
				b = false;
			}
		}
		ArrayList<Integer> find = new ArrayList<Integer>();
		if(b) {
			for (int i = 0; i < cnt.length; i++) {
				if(cnt[i]==max) {
					find.add(i-4000);
				}
			}
			Collections.sort(find);
			most = find.get(1);
		}

		System.out.println(Math.round((double)sum/N));
		System.out.println(num[midx]);
		System.out.println(most);
		System.out.println(num[N-1]-num[0]);
	}

}
