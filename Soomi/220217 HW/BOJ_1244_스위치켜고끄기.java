import java.util.Scanner;

public class BOJ_1244_스위치켜고끄기 {

	public static int num, N;

	public static void main(String[] args) {

		// 남학생: 받은 수의 배수면 switch
		// 여학생: 받은 번호-1 idx 중심, 좌우 대칭이면서 가장 많이 switch

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // switch 개수
		int[] Switch = new int[N];

		// switch 상태, on:1 off:0
		for (int n = 0; n < N; n++) {
			Switch[n] = sc.nextInt();
		}

		int student = sc.nextInt();

		// 학생 수 만큼 switch
		for (int s = 0; s < student; s++) {
			int gender = sc.nextInt(); // man:1 woman:2
			num = sc.nextInt();

			if (gender == 1) {
				for (int i = 0; i < N; i++) {
					man(num, Switch, i);
				}
			} else {
				// 가운데 바꾸기
				Switch[num - 1] = 1 - Switch[num - 1];
				// 양 옆 바꾸기
				woman(num, Switch);
			}

		} // end switch

		for (int i = 1; i <= N; i++) {
			
			System.out.printf("%d ", Switch[i-1]);
			// 20줄에 한 번씩 엔터
			if (i % 20 == 0) {
				System.out.println();
			}
		}

	}// end main

	public static void man(int n, int[] s, int idx) {
		// n의 배수 자리 switch
		if ((idx + 1) % n == 0) {
			s[idx] = 1 - s[idx];
		}
	}

	public static void woman(int n, int[] s) {

		for (int i = 1; i < N / 2; i++) {

			// 범위 벗어나면 탈출
			if (n - i - 1 < 0 || n + i - 1 >= N) {
				break;
			}
			// 양 옆으로 같으면 switch
			if (s[n - i - 1] == s[n + i - 1]) {
				s[n - i - 1] = 1 - s[n - i - 1];
				s[n + i - 1] = 1 - s[n + i - 1];
			} else
				break;
		} // end for

	}// end woman

}
