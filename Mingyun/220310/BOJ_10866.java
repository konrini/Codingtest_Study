package BOJ_220309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10866_덱 {

	static int front = -1; // queue의 맨 앞 index
	static int back = -1; // queue의 맨 뒤 index
	static int size = 0; // queue 의 사이즈
	static int[] deque = new int[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 명령어의 개수 : N
		int N = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < N; tc++) {
			String[] now = br.readLine().split(" ");

			if (now.length == 2) {
				// 이 경우는 push밖에 없음, "push" "2" 이런느낌
				int toPush = Integer.parseInt(now[1]);
				// 여기서 이제 back이냐 front이냐 나뉨
				
				if (now[0].equals("push_back")) {
					// 두가지 경우의 수가 나뉜다: size == 0 일때
					if (size == 0) {
						
						// 비어있을 때 맨뒤 인덱스 1 증가, 맨 앞 인덱스 증가한 back으로. deque에 삽입, size 증가
						deque[++back] = toPush;
						front = back;
						size++;

					} else {
						// 값이 있을 때, 맨뒤값 인덱스 1 증가시키고 deque에 삽입 size 증가
						deque[++back] = toPush;
						size++;
					}
					// push front의 경우..
				} else {
					if (size == 0) {
						deque[++back] = toPush;
						front = back;
						size++;

					} else {
						// back부터 front까지, 한 칸씩 뒤로 옮기기
						for (int idx = back; idx >= front; idx--) {
							deque[idx + 1] = deque[idx];
						} // 한 칸 밀기 끝
						size++;
						deque[front] = toPush;
						// back 1 증가시켜야함
						back++;
					}

				}
			} else {
				switch (now[0]) {
				// back인 경우, 비어있으면 -1, 아니면 back 인덱스 뽑아주기
				case "back":
					if (size == 0) {
						System.out.println(-1);
					} else {
						System.out.println(deque[back]);
					}
					break;
				// size 그대로출력
				case "front":
					// front 인 경우, 비어있으면 -1, 아니면 front 인덱스 뽑아주기
					if (size == 0) {
						System.out.println(-1);
					} else {
						System.out.println(deque[front]);
					}
					break;
				// size 그대로출력
				case "size":
					System.out.println(size);
					break;
				// size가 0이라면 1, 아니면 0
				case "empty":
					if (size == 0) {
						System.out.println(1);
					} else {
						System.out.println(0);
					}
					break;
				// size가 0이라면 그냥 -1 출력
				// 아니면 사이즈 줄이고, front 출력 후 1 증가시키기
				case "pop_front":
					if (size == 0) {
						System.out.println(-1);
					} else {
						size--;
						System.out.println(deque[front++]);
					}
					break;
					// size가 0이라면 그냥 -1 출력
					// 아니면 사이즈 줄이고, back 출력 후 1 감소시키기
				case "pop_back":
					if (size == 0) {
						System.out.println(-1);
					} else {
						size--;
						System.out.println(deque[back--]);
					}
					break;
				}
			}
		}
	}
}