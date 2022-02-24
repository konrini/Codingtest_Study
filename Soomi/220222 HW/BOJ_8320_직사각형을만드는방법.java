import java.util.Scanner;

public class BOJ_8320_직사각형을만드는방법 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 정사각형 n개
		int cnt = 0;

		for (int x = 1; x <= n; x++) {
			for (int y = x; x * y <= n; y++) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

}
