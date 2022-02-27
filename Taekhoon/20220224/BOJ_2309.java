package boj.class2;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] heights = new int[9];
		for (int i = 0; i < 9; i++) {
			heights[i] = sc.nextInt();
		}
		Arrays.sort(heights); // 입력받은 키들을 오름차순으로!
		
		// 제외될 인덱스 저장하는 변수
		int exception1 = 0;
		int exception2 = 0;
		
		int sum = 0; // 키의 합 저장하는 변수
		
		// 제외할 인덱스 선택
		for(int i = 0; i < 8; i ++) {
			if(sum == 100) break;
			for(int j = i+1; j <9; j++) {
				sum = 0;
				exception1 = i;
				exception2 = j;
				// 제외된 인덱스 빼고 키를 저장
				for(int k = 0; k < 9;k++) {
					if(k == exception1 || k == exception2) continue;
					else sum += heights[k];
				} // 7명의 키 더하기 종료
				
				// 키의 합이 100이면 출력 후 종료
				if (sum == 100) {
					for(int m = 0; m < 9; m++) {
						if(m == exception1 || m == exception2) continue;
						else System.out.println(heights[m]);
					}
					break;
				}
			}
		}
	}
}
