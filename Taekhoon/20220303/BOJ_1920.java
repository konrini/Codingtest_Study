package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1920_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // N개의 정수
		Set<Integer> numSet = new HashSet<>();
		

		// 정보 입력 받기
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringBuilder sb1 = new StringBuilder();
		for (int i = 0; i < N; i++) {
			numSet.add(Integer.parseInt(st1.nextToken()));
		}

		int M = Integer.parseInt(br.readLine()); // 찾아야하는 수의 개수
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			if(numSet.contains(Integer.parseInt(st2.nextToken()))) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}

	}
}
