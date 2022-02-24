import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2628_종이자르기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); // 가로 입력
		int b = sc.nextInt(); // 세로 입력
		int ndot = sc.nextInt(); // 점선 개수

		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> y = new ArrayList<>();

		for (int i = 0; i < ndot; i++) {
			int dot = sc.nextInt();
			if (dot == 0) {
				x.add(sc.nextInt());
			} else {
				y.add(sc.nextInt());
			}
		} // 입력 끝
		
		x.add(0);
		y.add(0);

		int maxx = 0;
		Collections.sort(x);
		// 가장 긴 가로 찾기
		if (x.size() == 0) {
			maxx = a;
		} else {
			for (int i = 1; i < x.size(); i++) {
				maxx = Math.max(maxx, x.get(i) - x.get(i - 1));
			}
		}
		
		int maxy = 0;
		Collections.sort(y);
		// 가장 긴 세로 찾기
		if (y.size() == 0) {
			maxy = b;
		} else {
			for (int i = 1; i < y.size(); i++) {
				maxy = Math.max(maxy, y.get(i) - y.get(i - 1));
			}
		}

		maxx = Math.max(maxx, b - x.get(x.size() - 1));
		maxy = Math.max(maxy, a - y.get(y.size() - 1));

		System.out.println(maxx * maxy);

	}

}
