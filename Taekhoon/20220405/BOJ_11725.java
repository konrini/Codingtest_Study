package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_11725 {
	static boolean[] visited; // 방문한 노드인지 확인
	static int[] parent; // 부모노드의 번호 저장
	static HashMap<Integer, ArrayList<Integer>> myMap; // 노드들간의 연결상태 저장
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];

		// 정점 2개 나오면 연결 상태 표시해주기
		myMap = new HashMap<>();

		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			// num1이 key에 있으면 value값인 list에 num2 추가
			if( myMap.containsKey(num1)) {
				myMap.get(num1).add(num2);
			// num1이 key에 없으면 list형태로 값 추가
			} else {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(num2);
				myMap.put(num1, temp);
			}
			// num2에 대해서도 똑같이
			if( myMap.containsKey(num2)) {
				myMap.get(num2).add(num1);
			} else {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(num1);
				myMap.put(num2, temp);
			}
		}
		
		// 부모노드 배열 초기화
		parent = new int[N+1];
		findParent(1);
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i <=N;i++) {
			sb.append(parent[i] + "\n");
		}
		System.out.println(sb);
		
		
	}
	
	static void findParent(int idx) {
		// 현재 노드번호 방문한 것으로 바꾸기
		visited[idx] = true;
		
		// 인접 노드의 정보 불러오기
		ArrayList<Integer> adj = myMap.get(idx);
		
		
		for(int i = 0 ; i < adj.size();i++) {
			// 인접노드 보면서 방문 안한 노드로 가고
			if( !visited[adj.get(i)]) {
				// 그 노드의 부모인 idx를 부모 배열에 저장
				parent[adj.get(i)] = idx;
				findParent(adj.get(i));
			}
		}
	}
}
