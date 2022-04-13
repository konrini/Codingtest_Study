package boj.class3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_17626 {
	static int max;
	static int n;
	static int r;
	static int[] data;
	static int[] sel;
	static int result;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		max = (int) Math.sqrt(n);
		data = new int[max];
		ans = 5;
		for(int i = max; i >=1; i--) {
			data[i-1] = i;
		}
		
		
		// 최대 4개까지만 뽑겠다.
		for (int i = 1; i <= 4; i++) {
			if(ans <= r) {
				break;
			}
			r = i;
			sel = new int[r];
			comb(0, 0);
		}
		System.out.println(ans);

	}
	// 중복조합...
	static void comb(int idx, int sidx) {
		if(ans <= r) {
			return;
		}
		if (sidx == r) {
			
			// 제곱합계산
			result = 0;
			for (int i = 0; i < r; i++) {
				result += sel[i] * sel[i];
			}
			// 합이 n이면 출력
			if (result == n) {
				System.out.println(Arrays.toString(sel));
				ans = Math.min(ans, r);
			}
			return;
		} else if (idx >= n) {
			return;
		} else {
			for(int i = idx; i < data.length; i++) {
				sel[sidx] = data[i];
				comb(i, sidx+1);
			}
		}
	}

}
