package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {
	static int N; // 영상의 크기
	static int[][] pic; // 2차원 배열로 표현된 영상
	static StringBuilder sb; // 정답 출력용
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pic = new int[N][N];
		for(int i = 0 ; i < N;i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				pic[i][j] = str.charAt(j) - '0';
			}
		}
		
//		for(int i = 0 ; i < N ;i++) {
//			System.out.println(Arrays.toString(pic[i]));
//		}
		sb = new StringBuilder();
		quadTree(0,0,N);
		System.out.println(sb);
	}
	
	static void quadTree(int row, int col, int size) {
		
		int initial = pic[row][col];
		boolean flag1 = true;
		outer1: for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				if(pic[i][j] != initial) {
					flag1 = false;
					break outer1;
				}
			}
		}
		if(flag1) {
			sb.append(initial);
			return;
		}
		sb.append("(");
		// 시작점의 행(i), 열(j)
		for(int i  = row ; i < row + size; i+= size/2) {
			for(int j = col ; j < col + size; j +=size/2) {
				// 시작점의 원소(0인지 1인지...)
				initial = pic[i][j];
				
				// 모든 원소가 같은 숫자로 이루어져있으면 true
				boolean flag = true;
//				if(size == 2) {
//					for(int r = 0 ; r < size; r++) {
//						for(int c = 0 ; c < size; c++) {
//							if(pic[i+r][j+c] == initial)
//						}
//					}
//				}
				// 모든 원소가 같은 숫자로 이루어져있는지 판단시작
				outer: for(int r = 0 ; r < size/2; r++) {
					for(int c = 0 ; c < size/2; c++) {
						// 하나라도 다른 숫자 있으면
						if(pic[i+r][j+c] != initial) {
							flag = false;
							// 사이즈 줄여서 quadTree 시작
							quadTree(i,j, size/2 );
							
							break outer;
						}
					}
				}
				if(flag) {
					sb.append(initial);
				}
			}
		}
		sb.append(")");
		return;
	}
}
// ((110(0101))(0010)1(0001))