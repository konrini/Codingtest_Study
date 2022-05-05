package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389_케빈베이컨의6단계법칙 {
	static int N, M;
	static int[][] arr; // 인접행렬
	static int[] visited; // 방문처리
	static int[] kevin; // 케빈베이컨의 수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1]; // 인접행렬 초기화, 인덱스 1번부터 사용
		
		for(int i = 0 ; i < M;i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			// A B 이면 A,B와 B,A 모두 친구 -> 무향그래프
			
			arr[n1][n2] = arr[n2][n1] = 1;
		}
		
		
		kevin = new int[N+1]; // 케빈베이컨 초기화
		
		// 전체 다 돎
		for(int i = 1 ; i <= N;i++) {
			for(int j = 1 ; j <= N;j++) {
				// 방문처리 초기화
				visited = new int[N+1];
				
				// bfs
				if(i != j) { // 자기자신한테 가는 경우 제외하고 bfs결과값 저장할 심산
					kevin[i] += bfs(i,j);
				}
			}
		}
		// 케빈베이컨 숫자가 작은 인덱스를 뽑을 예정
		int ans = 1;
		// 같은 최솟값일 경우 인덱스 작은 값이 정답이므로 인덱스 끝에서 시작
		for(int i = N; i >= 1;i--) {
			if(kevin[i] <= kevin[ans]) {
				ans = i;
			}
		}
		System.out.println(ans);
	}
	
	// bfs로 st에서 ed로 가는 최단거리(=케빈베이컨 수) 구하기
	static int bfs(int st, int ed) {
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(st);
		visited[st] = 1;
		outer: while(!q.isEmpty()) {
			
			int size = q.size();
			cnt += 1;
			for(int i = 0 ; i < size;i++) {
				int tmp = q.poll();
				for(int j = 0 ; j <= N;j++) {
					if(visited[j] == 0 && arr[tmp][j] == 1) {
						if(j == ed) {
							break outer;
						} else {
							q.add(j);
							visited[j] = 1;
						}
					}
				}
			}
		}
		return cnt;
	}
}
