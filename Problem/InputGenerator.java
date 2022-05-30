package STUDY_220530;

import java.io.OutputStream;
import java.util.HashSet;
import java.util.Iterator;

public class InputGenerator {
	// N : 지도의 차원개수
	// set을 사용을 해서, Math.random용해서
	// 4 <= N <= 50
	// M : 사람 수
	// 0 < M <= N*N
	// M의 좌표
	// 0<= M의 좌표(하나) < N;

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int testCase = 50;
		sb.append(testCase).append('\n');
		for (int t = 0; t < testCase; t++) {
			int N = (int) (Math.random() * 47) + 4; // 사실 중복 OK
			// 같은 좌표가 나오면 안 되는 것에 유의
			int M = (int) (Math.random() * N * N) + 1;
			// 0과 N-1 사이의 수들이 있고
			// 이게 M개 있고, 겹치지 않아야 좌표가 생성된다.
			HashSet<String> avoidDuplicate = new HashSet<>();
			// 총 M개 필요하니
			// [1,2] [1,3]
			// M개의 좌표가 필요하고
			// while 문을 써서 하자
			int cnt = 0;// ==> 이건 M까지 가야함

			while (cnt < M) {
				int r = (int) (Math.random() * N);
				int c = (int) (Math.random() * N);
				if(r == 0 && c == 0) continue;
				// System.out.println(r + "/" + c );
				String coordinate = r + "/" + c;
				
				// 안 되면 있다는 거니까
				if (!avoidDuplicate.contains(coordinate)) {
					cnt++;
					avoidDuplicate.add(coordinate);
				}

			} // 총 M개 처리 완료

			// 하나씩 뽑아서, 이제 예시 배열을 만들어야 하는 부분
			int[][] arr = new int[N][N];
			// 넘버링 필요하긴 함

			Iterator<String> it = avoidDuplicate.iterator();
			int index = 1;
			while (it.hasNext()) {
				String[] now = it.next().split("/");
				int row = Integer.parseInt(now[0]);
				int col = Integer.parseInt(now[1]);
				arr[row][col] = index++;
			}
			sb.append(N).append(' ');
			sb.append(M).append('\n');
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (j != N - 1)
						sb.append(arr[i][j]).append(' ');
					else {
						sb.append(arr[i][j]).append('\n');
					}
				}
			}
		}
		System.out.println(sb);
	}
}
