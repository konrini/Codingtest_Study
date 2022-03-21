package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2805 {
	static int MAX = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		
		ArrayList<Integer> trees = new ArrayList<>();
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		// 나무 높이 입력
		for(int i = 0;i <N;i++) {
			trees.add(Integer.parseInt(st2.nextToken()));
		}
		
		int start = 0;
		int end = MAX;
		int ans = 0; // 자를 수 있는 최대 높이
		while(start <= end) {
			int mid = (start + end) / 2;
			long sum = 0;
			for(int i = 0 ; i < N; i++) {
				// 자를려고 하는 높이보다 나무의 높이가 큰 경우에만 sum에 추가
				sum += (trees.get(i) - mid > 0) ? trees.get(i) - mid : 0; 
			}
			
			// M보다 큰 경우가 우리가 원하는 경우
			if(sum >= M) {
				ans = Math.max(mid, ans); // 잘랐던 높이(mid)가 현재 ans보다 클 때 ans 갱신
				start = mid + 1;
				
			} else {
				end = mid -1;
			}
		}
		
		System.out.println(ans);
	}
}
