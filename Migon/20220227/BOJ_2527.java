import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int cases = 0; cases < 4; cases++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 첫 번째 직사각형
			int[] rec1 = new int[4];
			for (int i = 0; i < 4; i++) {
				rec1[i] = Integer.parseInt(st.nextToken());
			}
			// 두 번째 직사각형
			int[] rec2 = new int[4];
			for (int i = 0; i < 4; i++) {
				rec2[i] = Integer.parseInt(st.nextToken());
			}
			// 크기 비교
			int leftmax = Math.max(rec1[0], rec2[0]);
			int downmax = Math.max(rec1[1], rec2[1]);
			int rightmin = Math.min(rec1[2], rec2[2]);
			int upmin = Math.min(rec1[3], rec2[3]);
			String ans;
			// 겹치는 경우
			if (rightmin - leftmax > 0 && upmin - downmax > 0) {
				ans = "a";
			}
			// 점으로 만나는 경우
			else if (rightmin - leftmax == 0 && upmin - downmax == 0) {
				ans = "c";
			}
			// 분리된 경우
			else if (rightmin - leftmax < 0 || upmin - downmax < 0) {
				ans = "d";
			}
			// 선분으로 만나는 경우
			else {
				ans = "b";
			}
			System.out.println(ans);
		}
	}
}