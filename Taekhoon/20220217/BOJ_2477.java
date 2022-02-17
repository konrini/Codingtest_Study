package boj.class2;

import java.util.Scanner;

public class BOJ_2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력방향에 상관없이 회전이동을 하면 모양은 동일
		// 따라서 가장 긴 변이 첫번째로 입력이 되면 내가 계산할려고 하는 육각형이 정해짐
		int cnt = sc.nextInt(); // 단위 면적당 참외 생산량
		int[] len = new int[6]; // 길이의 입력순서를 유지하는 배열


		for (int i = 0; i < 6; i++) {
			sc.nextInt();
			len[i] = sc.nextInt();
		}

		// 배열의 0번 변과 배열의 5번 변이 긴 두변으로 정해지면 원하는 모양이 됨. 
		while ((len[0] != len[2] + len[4]) || len[5] != len[1] + len[3]) {
			rightShift(len);
		}
		int result = ((len[0] * len[5]) - (len[2] * len[3])) * cnt;
		System.out.println(result);

	}

	// 배열을 한 칸씩 오른쪽으로 옮기는 함수
	public static void rightShift(int[] arr) {
		int temp = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			arr[i + 1] = arr[i];
		}
		arr[0] = temp;
	}
}
