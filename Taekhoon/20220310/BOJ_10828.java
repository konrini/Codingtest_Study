package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10828_1 {// 스택
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cmd = Integer.parseInt(br.readLine()); // 명령의 수
		// 정수를 담을 배열 생성
		int[] numbers = new int[10000]; // 명령의 수가 최대 10000개이므로 크기 10000으로
		int peekIdx = -1; // 가장 최근에 스택에 저장된 인덱스
		StringTokenizer st;
		for (int i = 0; i < cmd; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case ("push"):
				// push명령이 들어오면 peekIdx에 1을 더해주고 그 인덱스에 들어온 값 추가
				numbers[++peekIdx] = Integer.parseInt(st.nextToken());
				break;
			case ("pop"):
				// pop명령이 들어오면 현재 스택의 peek인덱스를 하나 빼준다.
				// 0보다 작으면 뺄 정수가 없으므로 아무 작업도 하지 않음
				if (peekIdx >= 0) {
					System.out.println(numbers[peekIdx]);
					peekIdx--;
				} else {
					System.out.println(-1);
				}
				break;
			case ("size"):
				// size는 가장 최근에 스택에 저장된 인덱스+1 입니다.
				if (peekIdx == -1) {
					System.out.println(0);
				} else {
					System.out.println(peekIdx + 1);
				}
				break;
			case ("empty"):
				if (peekIdx == -1) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case ("top"):
				if (peekIdx == -1) {
					System.out.println(-1);
				} else {
					System.out.println(numbers[peekIdx]);
				}
				break;
			}

		}
	}
}
