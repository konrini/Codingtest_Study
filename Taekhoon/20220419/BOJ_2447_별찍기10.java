package boj.class3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2447_별찍기10_1 {
	static int N;
	static String[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new String[N][N];
		
		// 처음에 전부 별로 표시
		for(int i = 0 ; i < N;i++) {
			Arrays.fill(arr[i], "*");
		}
		
		// 별 찍기 시작
		start(0,0,N);
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N;i++) {
			for(int j = 0 ; j < N;j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void start(int r, int c, int size) {
		if(size == 1) {
			return;
		}
		
		// 해당 재귀깊이(?)에서 중간에 비도록 해줌
		for(int i = r+size/3; i < r + size/3 * 2; i++) {
			for(int j = c + size/3; j < c + size/3 * 2; j++) {
				arr[i][j] = " ";
			}
		}
		
		// 시작점을 옮기면서 재귀 호출
		for(int i = r; i < r + size; i+=size/3) {
			for(int j = c; j < c + size; j+= size/3) {
				start(i, j, size/3);
			}
		}
	}
}
