package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11403_경로찾기 {
	
	static int N;
	static int[][] arr; // 인접행렬
	static int[][] result; // 결과
	static boolean[] visited; // 방문처리
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		result = new int[N][N];
		for(int i = 0 ; i <  N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			visited = new boolean[N];
			bfs(i);
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i =0; i < N;i++) {
			for(int j = 0 ; j < N;j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int i = 0 ; i < N; i++) {
				if(arr[tmp][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					
					// 일단 여기에 들어왔다는 것은 start에서 도달 할 수 있는 곳이므로 result를 1로 바꿈
					result[start][i] = 1;
				}
			}
		}
	}
	
	
	
}
