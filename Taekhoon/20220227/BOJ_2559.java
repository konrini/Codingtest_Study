package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] temper = new int[N];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			temper[i] = Integer.parseInt(st2.nextToken());
		}
//		System.out.println(Arrays.toString(temper));
		
		int max = Integer.MIN_VALUE;
		for(int i =0; i< N-K+1;i++) {
			int sum = 0;
			for(int j = 0; j< K; j++) {
				sum += temper[i+j];
			}
//			System.out.println(sum);
			if(sum > max) max = sum;
		}
		System.out.println(max);
	}
}
