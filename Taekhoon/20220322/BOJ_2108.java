package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2108 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> lst = new ArrayList<>();
		
		// 최빈값 계산을 위한 배열
		int[] count = new int[8001];
		
		// 산술 평균 계산을 위한 총합
		double sum = 0;
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			count[temp + 4000]++; // 빈도수 계산
			sum += temp;
			lst.add(temp);
		}
		// 산술 평균
		sb.append(Math.round(sum / N) + "\n");

		Collections.sort(lst);

		// 중앙값
		sb.append(lst.get(N / 2) + "\n");

		// 최빈값
		int max = -1; // 빈도수의 최댓값
		int idx = 0; // 최댓값에 해당하는 인덱스
		int check = 0; // 최빈값이 여러 개일 경우 2개까지 세기 위한 변수
		
		// 일단 빈도수의 최댓값 계산
		for (int i = 0; i < 8001; i++) {
			if (count[i] >= max) {
				max = count[i];
			}
		}
		
		// 다시 돌면서 빈도수의 최댓값일 때의 인덱스 확인
		for(int i = 0; i < 8001;i++) {
			if(count[i] == max) {
				idx = i;
				check++;
				
				// 최빈값이 2개인 경우 배열 그만 돌기
				if(check==2) {
					break;
				}
			}
		}
		
		// 인덱스를 양수로 해주기 위해 더했던 4000을 빼줌
		sb.append((idx - 4000) + "\n");

		// 범위
		sb.append((lst.get(N - 1) - lst.get(0)) + "\n");

		System.out.println(sb.toString());

	}
}
