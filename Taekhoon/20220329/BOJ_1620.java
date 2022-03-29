package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		
		// key값으로 영문 이름, value값으로 번호를 integer형태로 입력함
		HashMap<String,  Integer> poke1 = new HashMap<>();
		String[] poke2 = new String[N+1];
		for(int i = 1 ; i <= N;i++) {
			String temp = br.readLine();
			poke1.put(temp, i);
			poke2[i] = temp;
		}
		
		
		for(int i = 0; i < M; i++) {
			String temp = br.readLine();
			
			// 현재 탐색하는 값이 번호인 경우
			if(isNum(temp)) {
				sb.append(poke2[Integer.parseInt(temp)] +"\n");
			// 현재 탐색하는 값이 문자열인 경우
			}else {
				sb.append(poke1.get(temp) + "\n");
			}
		}
		System.out.println(sb);

		
		
	}

	public static boolean isNum(String str) {
		for (int i = 0; i < str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))){
				return false;
			}
		}
		return true;
	}
}
