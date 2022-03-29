package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> myList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String cmd = br.readLine();
			StringTokenizer st = new StringTokenizer(cmd);
			int temp;
			boolean flag;
			switch (st.nextToken()) {
			case "add":
				temp = Integer.parseInt(st.nextToken());

				// 리스트에 입력 받은 값이 있는지 확인
				flag = false;
				for (int j = 0; j < myList.size(); j++) {

					// 입력받은 값이 존재하면 flag를 true
					if (temp == myList.get(j)) {
						flag = true;
						break;
					}
				}

				// 입력받은 값이 없으면 추가
				if (!flag) {
					myList.add(temp);
				}

				break;
			case "remove":
				temp = Integer.parseInt(st.nextToken());
				// 리스트에 입력 받은 값이 있는지 확인
				for (int j = 0; j < myList.size(); j++) {
					// 입력받은 값이 존재하면 제거
					if (temp == myList.get(j)) {
						myList.remove(j);
						break;
					}
				}

				break;

			case "check":
				temp = Integer.parseInt(st.nextToken());

				// 리스트에 입력 받은 값이 있는지 확인
				flag = false;
				for (int j = 0; j < myList.size(); j++) {
					// 입력받은 값이 존재하면 flag를 true
					if (temp == myList.get(j)) {
						flag = true;
						sb.append(1 + "\n");
						break;
					}
				}

				// 입력받은 값이 없으면 추가
				if (!flag) {
					sb.append(0 + "\n");
				}
				break;

			case "toggle":
				temp = Integer.parseInt(st.nextToken());

				// 리스트에 입력 받은 값이 있는지 확인
				flag = false;
				for (int j = 0; j < myList.size(); j++) {
					// 입력받은 값이 존재하면 flag를 true
					if (temp == myList.get(j)) {
						flag = true;
						// 입력받은 값이 있으면 삭제
						myList.remove(j);
						break;
					}
				}

				// 입력받은 값이 없으면 추가
				if (!flag) {
					myList.add(temp);
				}
				break;
			case "all":
				// 비우고
				myList.clear();
				// 새로 입력
				for (int num = 1; num <= 20; num++) {
					myList.add(num);
				}
				break;
			case "empty":
				// 비우기
				myList.clear();
				break;
			}
		} // 명령 입력 종료
		
		// 출력
		System.out.println(sb);

	}
}
