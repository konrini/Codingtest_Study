package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10845 { // 쿠ㅠ
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cmd = Integer.parseInt(br.readLine()); // 명령의 수
		// 정수를 담을 배열 생성
		int[] numbers = new int[10000]; // 명령의 수가 최대 10000개이므로 크기 10000으로
		int front = -1; // 큐에서 가장 최근에 제거된 인덱스
		int back = -1; // 큐의 가장 마지막 인덱스
		StringTokenizer st;
		for (int i = 0; i < cmd; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case ("push"):
				// 현재 큐의 가장 마지막 인덱스(back)에 1을 더하고 거기에 숫자 저장
				numbers[++back] = Integer.parseInt(st.nextToken());
				break;
			case ("pop"):
				if(front == back) { // 큐가 비어있는경우
					System.out.println(-1);
				} else { // 비어있지 않은 경우
					// front의 값을 1 올려주고 그 인덱스를 제거
					System.out.println(numbers[++front]);
				}
				break;
			case ("size"):
				System.out.println(back - front);
				break;
			case ("empty"):
				if(front == back) { // 맨앞의 인덱스와 맨뒤의 인덱스가 같으면 비어있음
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case ("front"):
				if(front == back) { // 비어있는 경우
					System.out.println(-1);
				} else {
					// 가장 최근에 제거된 인덱스에 +1한  인덱스의 값을 출력
					System.out.println(numbers[front+1]);
				}
				break;
			case ("back"):
				if(front == back) { // 비어있는 경우
					System.out.println(-1);
				} else {
					System.out.println(numbers[back]);
				}
				break;
			}

		}
	}
}
