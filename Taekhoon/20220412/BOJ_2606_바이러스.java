package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	static int N, M, ans;
	static int[] p;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 컴퓨터 개수
		M = Integer.parseInt(br.readLine()); // 연결시킬 횟수
		p = new int[N+1]; // 대표 번호 저장용
		ans = 0; // 정답
		
		// 자기자신을 대표로 만듦
		for(int i = 1; i <=N;i++) {
			makeSet(i);
		}
		
		// 입력 받고 union처리
		StringTokenizer st = null;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			union(num1, num2);
		}
		System.out.println(Arrays.toString(p));
		System.out.println();
		for(int i =1 ; i<=N;i++) {
			p[i] = findSet(i);
			// 대표값이 1번인덱스와 같으면 카운트
			if( p[i] == p[1]) {
				++ans;
			}
		}
		System.out.println(Arrays.toString(p));
		// 1번인덱스는 숙주이므로 제외
		System.out.println(ans-1);
	}
	
	static void makeSet(int x) {
		p[x] = x;
	}
	
	static int findSet(int x) {
		if(x== p[x]) {
			return x;
		} else {
			return findSet(p[x]);
		}
	}
	
	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}
