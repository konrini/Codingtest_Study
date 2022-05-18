package BOJ_220519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064_카잉달력 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int ansX = Integer.parseInt(st.nextToken()) - 1; // 나머지 연산을 위함
			int ansY = Integer.parseInt(st.nextToken()) - 1; // 나머지 연산을 위함
			boolean flag = false;
			// 이렇게 돌면, M이 5면, 0, 5, 10, 이렇게 도는데, 이게 결국 M으로 나눠떨어짐
			// 무조건 최소공배수 만큼만 돌아!
			// 특정 숫자의 결국 x좌표, y좌표 느낌은, 0~최소공배수까지 수를, 각각 M으로, N으로 나눈 나머지야
			for(int i=ansX; i<M*N; i+= M) {
				if(i % N == ansY) {
					System.out.println(i+1); // 나머지 연산을 위해 -1한거니, 원래 숫자는 1 더해야함
					flag = true;
					break;
				}
			}
			// 끝가지 돌았는데 못 찾으면 -1 출력
			if(!flag) {
				System.out.println(-1);
			}

	}


	}
}
