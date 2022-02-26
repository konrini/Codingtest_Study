package boj.class2;

import java.util.Scanner;

public class BOJ_2628_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int width = sc.nextInt();
		int height = sc.nextInt();

		int cut_cnt = sc.nextInt();

		// 잘려질 최대 길이만큼의 길이를 갖는 종이 생성
		// 가장 처음 잘리기 전의 한 칸은 1의 값을 갖는다.
		// 잘린 번호의 인덱스는 0으로 바꾸고 잘린쪽부터 오른쪽으로 한칸씩 이동
		int[][] paper = new int[height + cut_cnt][width + cut_cnt];

		// 초기 종이 모양 입력
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				paper[i][j] = 1;
			}
		} // 초기 종이모양 입력 종료

		// 자르기 시작
		int wCutCnt = -1;
		int hCutCnt = -1;
		for (int cnt = 1; cnt <= cut_cnt; cnt++) {
			int direction = sc.nextInt();
			if (direction == 0) {
				wCutCnt +=1;
				widthCut(paper, sc.nextInt()+wCutCnt);
			} else if (direction == 1) {
				hCutCnt += 1;
				heightCut(paper, sc.nextInt()+hCutCnt);
			}
		}

//		for (int i = 0; i < paper.length; i++) {
//			System.out.println(Arrays.toString(paper[i]));
//		}
		
		
		// 잘려진 모양중 가로의 최대길이와 세로의 최대길이를 찾는다.
		int wMax = 0;
		int hMax = 0;
		
		int temp = 0;
		for(int i = 0; i < width + cut_cnt;  i++) {
			if(paper[0][i] == 1) {
				temp += 1;
			} else {
				wMax = (temp > wMax) ? temp : wMax;
				temp = 0;
			}
		}
//		System.out.println(wMax);
		
		temp = 0;
		for(int i = 0; i < height + cut_cnt;  i++) {
			
			if(paper[i][0] == 1) {
				temp += 1;
			} else {
				hMax = (temp > hMax) ? temp : hMax;
				temp = 0;
			}
		}
//		System.out.println(hMax);
		
		
		// 넓이의 최댓값 출력
		System.out.println(wMax * hMax);
	}

	public static void widthCut(int[][] arr, int idx) {
		for (int j = 0; j < arr[0].length; j++) {
			for (int i = arr.length - 1; i >= idx; i--) {
				arr[i][j] = arr[i - 1][j];
			}
			arr[idx][j] = 0;
		}
	}

	public static void heightCut(int[][] arr, int idx) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr[i].length - 1; j >= idx; j--) {
				arr[i][j] = arr[i][j - 1];
			}
			arr[i][idx] = 0;
		}
	}
}
