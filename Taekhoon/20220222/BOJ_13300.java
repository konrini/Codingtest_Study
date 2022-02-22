package boj.class2;

import java.util.Scanner;

public class BOJ_13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 수학여행에 참가하는 학생수
		int K = sc.nextInt(); // 한 방에 배정할 수 있는 최대 인원수

		// 학년을 행으로, 성별을 열로하는 7*2 크기의 2차원 배열 생성
		// 학년의 경우 1학년부터 있으므로 크기를 7로 함
		int[][] students = new int[7][2];

		// 학생의 성별과 학년에 맞게 배열에 학생 수 저장
		for (int i = 0; i < N; i++) {
			int s = sc.nextInt();
			int y = sc.nextInt();
			students[y][s]++;
		}

		int cnt = 0; // 필요한 방의 개수
		
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				// 각 학년별, 성별 학생수를 최대 인원수로 나눴을때 나누어 떨어지면 몫을 전체 방 개수에 더해주고
				if (students[i][j] % K == 0) {
					cnt += students[i][j] / K;
				} else { // 나누어 떨어지지 않으면 몫에다가 1을 더해서 전체 방 개수에 더해줌
					cnt += students[i][j] / K + 1;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
