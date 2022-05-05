package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


//시간초과 나서 못 푼 문제!!!!!!!!!!!!!!!!!!!!!!!
public class BOJ_1931_회의실배정 {
	static int N;
	static int[][] startEnd;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		startEnd = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			startEnd[i][0] = s;
			startEnd[i][1] = e;
		}
		Arrays.sort(startEnd, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0] != o2[0]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}
		});
		ans = 0;
		for(int i = 0 ; i < N;i++) {
			dfs(i, 0);
		}
		System.out.println(ans);
	} // main

	public static void dfs(int idx, int cnt) {
		++cnt;
		if (startEnd[idx][1] > startEnd[N-1][0] || idx == N-1) {
			ans = Math.max(ans, cnt);
			return;
		}
		for (int i = idx+1; i < startEnd.length; i++) {
			if (startEnd[i][0] >= startEnd[idx][1]) {
				dfs(i, cnt);
			}
		}
	}
}
