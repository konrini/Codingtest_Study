package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		// 수의 개수
		int N = Integer.parseInt(st.nextToken());
		// 구해야하는 합의 개수
		int M = Integer.parseInt(st.nextToken());

		// 수를 저장하는 배열
		int[] sum = new int[N];
		st = new StringTokenizer(br.readLine());
		sum[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		// 구간합 구하기 시작
		int start, end;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			
			if(start == 1) {
				sb.append(sum[end-1]).append("\n");
			}else {
				sb.append(sum[end-1] - sum[(start-1) - 1]).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
