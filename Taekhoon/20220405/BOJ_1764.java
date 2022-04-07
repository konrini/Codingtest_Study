package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 듣지만 못한 이름 set
		HashSet<String> heard = new HashSet<>();
		
		// 듣지도 보지도 못한 이름 리스트
		ArrayList<String> heardSeen = new ArrayList<>();

		
		// 듣지만 못한 사람 입력 받기
		for (int i = 0; i < N; i++) {
			heard.add(br.readLine());
		}

		// 듣보 수
		int cnt = 0;
		
		// 보지만 못한 이름 받으면서 듣지만 못한 이름에 포함 되면 듣보 카운트 +1 하고 
		// 듣지도 보지도 못한 리스트에 추가
		for (int i = 0; i < M; i++) {
			String temp = br.readLine();
			if (heard.contains(temp)) {
				++cnt;
				heardSeen.add(temp);
			}
		}
		
		// sort쓰면 자동 사전순
		Collections.sort(heardSeen);
		
		// 출력
		StringBuilder sb = new StringBuilder();
		sb.append(cnt + "\n");
		
		for (int i = 0; i < heardSeen.size(); i++) {
			sb.append(heardSeen.get(i) + "\n");
		}
		System.out.println(sb);
	}

}
