package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {
	
	static int N, M;
	static int[][] p; // 해당인덱스의 대표노드와 랭크를 저장하는 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		p = new int[N+1][2]; // 배열 초기화, 인덱스 1부터
		
		for(int i = 0 ; i <=N;i++) {
			p[i][0] = i; // p[i]의 0번째에 대표노드를 자기자신으로 초기화
		}
		
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			union(u,v);
		}
		
		HashSet<Integer> cnt = new HashSet<>();
		for(int i = 1;i<=N;i++) {
			p[i][0] = findSet(i); // path-compression
			
			// 대표노드들을 set에 저장
			if(!cnt.contains(p[i][0])) {
				cnt.add(p[i][0]);
			}
		}
		// set의 사이즈가 연결요소의 개수
		System.out.println(cnt.size());
		
	}
	
	static int findSet(int x) {
		if (x != p[x][0]) {
			p[x][0] = findSet(p[x][0]);
		}
		return p[x][0];
	}
	
	static void union(int x, int y) {
		link(findSet(x), findSet(y));
	}
	
	// rank를 이용한 union
	// rank값이 작은애를 rank값이 큰 애한테 붙이기
	static void link(int x, int y) {
		if (p[x][1] > p[y][1]) {
			p[y][0] = p[x][0];
		} else {
			p[x][0] = p[y][0];
			if (p[x][1] == p[y][1]) {
				p[y][1]++;
			}
		}
	}
}
