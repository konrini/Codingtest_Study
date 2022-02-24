package boj.class2;

import java.util.Scanner;

public class BOJ_8320 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(makeSquare(n));

	}

	public static int makeSquare(int num) {
		// num이 1인 경우 리턴시작(?)
		if (num == 1)
			return 1;

		// num이 1이 아닌 경우
		int result = 0; // num개를 전부 사용해 만들 수 있는 직사각형의 개수

		int cnt = 0; // num의 약수의 개수
		for (int i = 1; i <= num; i++) {
			if (num % i == 0)
				cnt++;
		}
		if (cnt == 2)
			result = 1; // 약수의 개수가 2개(소수)인 경우는 1개 만들 수 있음
		else if (cnt % 2 == 1)
			result = cnt / 2 + 1; // 약수의 개수가 홀수인 경우(제곱수) {약수의 개수 절반+1} 개 만들 수 있다.
		else
			result = cnt / 2; // 그외 경우는 약수의 개수의 절반만큼 만들 수 있다.

		// num개로 만들 수 있는 직사각형의 개수는 num-1 개로 만들 수 있는 총 직사각형의 개수에
		// num개를 전부 이용해서 만들 수 있는 경우의 수를 더하면 구할 수 있음
		return result + makeSquare(num - 1);

	}
}
