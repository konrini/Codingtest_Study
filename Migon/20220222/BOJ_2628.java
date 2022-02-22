import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 종이의 가로와 세로의 길이
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		// 가로 커트
		List<Integer> r_cut = new ArrayList<>();
		// 세로 커트
		List<Integer> c_cut = new ArrayList<>();
		// 첫부분 삽입
		r_cut.add(0);
		c_cut.add(0);
		// 잘라야하는 점선의 개수
		int N = Integer.parseInt(br.readLine());
		// 자르기
		for (int i = 0; i < N; ++i) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			if (Integer.parseInt(st1.nextToken()) == 0) {
				r_cut.add(Integer.parseInt(st1.nextToken()));
			} else {
				c_cut.add(Integer.parseInt(st1.nextToken()));
			}
		}
		// 끝부분 삽입
		r_cut.add(r);
		c_cut.add(c);
		// 오름차순으로 정렬
		r_cut.sort(null);
		c_cut.sort(null);
		int max = 0;
		// 최대 넓이 출력
		for (int a = 1; a < r_cut.size(); ++a) {
			for (int b = 1; b < c_cut.size(); ++b) {
				max = Math.max((r_cut.get(a) - r_cut.get(a - 1)) * (c_cut.get(b) - c_cut.get(b - 1)), max);
			}
		}
		bw.write(max + "");
		bw.close();
	}
}