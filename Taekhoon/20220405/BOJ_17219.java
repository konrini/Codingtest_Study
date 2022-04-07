package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_17219 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, String> pwd = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 사이트주소를 key로 비밀번호를 value로 하는 맵
		for(int i =0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			pwd.put(st2.nextToken(), st2.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		// sb에 찾고자하는 사이트의 비밀번호 넣기
		for(int i=0;i<M;i++) {
			sb.append(pwd.get(br.readLine()) + "\n");
		}
		
		// 출력
		System.out.println(sb);
	}
}
