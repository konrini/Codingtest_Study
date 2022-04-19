package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2630_색종이만들기 {

	static int N;
	static int[][] paper;
	static int wCnt;
	static int bCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];

		// 입력받기
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		wCnt = 0;
		bCnt = 0;
		cut(paper);
		System.out.println(wCnt);
		System.out.println(bCnt);
//		System.out.println("하얀색종이: "+ wCnt);
//		System.out.println("파란색종이: " + bCnt);

	} // main

	// 하나의 색종이를 4부분으로 나눠서 조건에 만족하는지 확인 후 만족하지 않으면 재귀로 함수 호출

	static void cut(int[][] arr) {
		int size = arr.length;
//		for(int i =0;i <size;i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//		System.out.println();
		
		int white = 0; // 흰색의 수
		int blue = 0; // 파란색의 수
		
		boolean flag = false; // 더 나눠야할지 스탑할지
		// 하얀 색종이 확인
		outer1: for(int i = 0 ; i <size; i++) {
			for(int j = 0 ;j <size; j++) {
				if(arr[i][j] != 0) {
					break outer1;
				}
				++white;
			}
		}
		
		// 전부 하얀색이라면
		if(white == size*size) {
			flag = true;
			++wCnt; // 흰 종이 카운트 +1
		}
		
		// 파란 색종이 확인
		outer2: for(int i = 0 ; i <size; i++) {
			for(int j = 0; j <size; j++) {
				if(arr[i][j] != 1) {
					break outer2;
				}
				++blue;
			}
		}
		
		// 전부 파란색이라면
		if (blue == size*size) {
			flag = true;
			++bCnt; // 파란 종이 카운트 +1
		}
		if( flag) { // 한 가지색으로 만들어졌으면 종료
			return;
		} else { // 아니면 4부분으로 나눠서 다시 cut
			if(size == 1) return;
			int half = size/2;
			int[][] arr1 = new int[half][half];
			int[][] arr2 = new int[half][half];
			int[][] arr3 = new int[half][half];
			int[][] arr4 = new int[half][half];
			
			
			for(int i = 0; i < half; i ++) {
				for(int j = 0 ; j < half;j++) {
					arr1[i][j] = arr[i][j];
					arr2[i][j] = arr[i][j+half];
					arr3[i][j] = arr[i+half][j];
					arr4[i][j] = arr[i+half][j+half];
				}
			}
			
			cut(arr1);
			cut(arr2);
			cut(arr3);
			cut(arr4);
		}
		
		
	}
}
