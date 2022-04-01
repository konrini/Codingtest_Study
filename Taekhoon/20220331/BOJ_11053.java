package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11053 {
	static int N;
	static int[] arr;
	static int[] len;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		len = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			
			int maxLen = 0;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					if(len[j] > maxLen) {
						maxLen = len[j];
					}
				}
			}
			len[i] = maxLen+1;
			ans = Math.max(ans, len[i]);
//			System.out.println(Arrays.toString(len));
		}
		System.out.println(ans);
	}
}
/*
10
10 20 30 50 40 42 45 25 47 70

 */

