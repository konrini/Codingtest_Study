import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 스위치 개수
		int N = sc.nextInt();
		int[] light = new int[N];
		// 스위치 정보 받기
		for (int i = 0; i < N; ++i) {
			light[i] = sc.nextInt();
		}
		// 학생 수
		int p = sc.nextInt();
		// 스위치 바꾸기
		for (int j = 0; j < p; ++j) {
			int gender = sc.nextInt();
			if (gender == 1) {
				boy_switch(light, sc.nextInt());
			} else if (gender == 2) {
				girl_switch(light, sc.nextInt());
			}
		}
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < light.length; ++k) {
			sb.append(light[k]).append(" ");
			// 20개 출력하면 엔터
			if ((k + 1) % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	public static void boy_switch(int[] arr, int n) {
		// n의 배수 스위치 바꾸기
		for (int i = n - 1; i < arr.length; i += n) {
			arr[i] = 1 - arr[i];
		}
	}

	public static void girl_switch(int[] arr, int n) {
		// 자기 자신 바꾸기
		arr[n - 1] = 1 - arr[n - 1];
		int idx = 1;
		while (true) {
			// 범위 내에 있을 때
			if (n - 1 - idx >= 0 && n - 1 + idx < arr.length) {
				// 대칭이면 바꾸기
				if (arr[n - 1 + idx] == arr[n - 1 - idx]) {
					arr[n - 1 + idx] = 1 - arr[n - 1 + idx];
					arr[n - 1 - idx] = 1 - arr[n - 1 - idx];
					++idx;
					continue;
				}
				break;
			}
			break;
		}
	}
}
