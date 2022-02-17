package boj.class2;

import java.util.Scanner;

public class Boj_7568 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 사람의 몸무게와 키를 저장하는 2차원 배열 생성
		int[][] infos = new int[N][2];
		
		// 입력받은 값들을 infos에 저장
		for(int i = 0; i< N;i++) {
			for(int j =0; j < 2; j++) {
				infos[i][j] = sc.nextInt();
			}
		}
		
		// 각 사람의 순위를 저장하는 1차원 배열 생성
		int[] order = new int[N];
		
		// 각 사람의 덩치 값과 나머지 사람들을 비교하여 자신보다 덩치가 큰사람이 있으면 순위에 1을 더해줌
		for(int i = 0; i< N;i++) {
			order[i] = 1; // 가장 높은 순위가 1위이므로 1로 초기화
			for(int j = 0; j < N; j++) {
				if(infos[i][0] < infos[j][0] && infos[i][1] < infos[j][1]) {
					order[i]++;
				}
			}
		}
		// 출력 형식에 맞게 프린트
		for(int i = 0; i < N-1; i++) {
			System.out.print(order[i] + " ");
		}
		System.out.print(order[N-1]);
	}
}
