package BOJ_220309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10828_스택 {

	static int top = -1; // stack의 최상단 index
	static int size = 0; // stack의 사이즈
	static int[] stack = new int[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 명령어의 개수 : N
		int N = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < N; tc++) {
			String[] now = br.readLine().split(" ");

			if (now.length == 2) {
				// 이 경우는 push밖에 없음, "push" "2" 이런느낌
				int toPush = Integer.parseInt(now[1]);
				// size 1 더해주면서, 값 넣기
				stack[size++] = toPush;
				// 최대값의 인덱스 1 증가
				top++;
			} else {
				switch (now[0]) {
				// top인 경우, 비어있으면 -1, 아니면 top인덱스 뽑아주기
				case "top":
					if (size == 0) {
						System.out.println(-1);
					} else {
						System.out.println(stack[top]);
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
				// size가 0이라면 그냥 -1 출력 아니면 사이즈 줄이고, top 출력 후 1 줄이기
				case "pop":
					if (size == 0) {
						System.out.println(-1);
					} else {
						size--;
						System.out.println(stack[top--]);
					}
				}
			}
		}
	}
}