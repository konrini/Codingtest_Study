package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10866 { // 덱(Deque)
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cmd = Integer.parseInt(br.readLine()); // 명령의 수
		// 정수를 담을 배열 생성
		int[] numbers = new int[10000]; // 명령의 수가 최대 10000개이므로 크기 10000으로
		int front = -1; // 덱에서 가장 최근에 제거된 인덱스
		int back = -1; // 덱의 가장 마지막 인덱스
		StringTokenizer st;
		for (int i = 0; i < cmd; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case ("push_front"):
				// 가장 앞의 인덱스를 비워주고 한칸씩 뒤로 민 다음 비어있는 인덱스에 정수 추가
				for (int j = back; j >= front+1; j--) {
					numbers[j + 1] = numbers[j];
				}
				back++;
				numbers[front + 1] = Integer.parseInt(st.nextToken());
				break;
			case ("push_back"):
				// back의 값을 하나 올려주고 거기에 정수 추가
				numbers[++back] = Integer.parseInt(st.nextToken());
				break;
			case ("pop_front"):
				if(front == back) {
					System.out.println(-1);
				} else {
					System.out.println(numbers[++front]);
				}
				break;
			case ("pop_back"):
				if(front == back) {
					System.out.println(-1);
				} else {
					System.out.println(numbers[back--]);
				}
				break;
			case ("size"):
				System.out.println(back-front);
				break;
			case ("empty"):
				if(front == back) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case ("front"):
				if(front == back) {
					System.out.println(-1);
				} else {
					System.out.println(numbers[front+1]);
				}
				break;
			case ("back"):
				if(front == back) {
					System.out.println(-1);
				} else {
					System.out.println(numbers[back]);
				}
				break;
			}

		}
	}
}
