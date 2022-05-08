package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_9375_패션왕 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());

			// 옷 종류를 key, 그 종류에 해당하는 옷개수를 value로
			HashMap<String, Integer> clothes = new HashMap<>();

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken(); // 옷의 이름(필요없음)
				String where = st.nextToken(); // 종류

				// 한번 나왔던 종류이면 개수 1 증가시키기
				if (clothes.containsKey(where)) {
					int temp = clothes.get(where);
					clothes.put(where, temp + 1);
				} else { // 처음 나오면 map에 추가
					clothes.put(where, 1);
				}
			} // 입력값 받기 종료

			int ans = 1; // 정답

			// 각 종류에 있는 옷의 개수에 안입는 것까지 고려하기 위해 1을 더하고 서로 곱해줘서 입을 수 있는 방법들 계산
			for (String key : clothes.keySet()) {
				ans *= (clothes.get(key) + 1);
			}

			// 알몸인 경우까지 ans에 포함되어 있으므로 1빼고 출력
			System.out.println(ans - 1);
		}

	}

}
