package boj.class2;

import java.util.Scanner;

public class Boj_2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		System.out.println(findvalue(num1, num2)[0]);
		System.out.println(findvalue(num1, num2)[1]);

	} // main함수 종료

	public static int[] findvalue(int number1, int number2) {
		
		// 함수의 리턴값으로 최대공약수, 최소공배수를 담은 배열
		int[] ans = {1,1};
		
		// 입력받은 두 수 중 큰 수를 bigN, 작은 수를 smallN에 담는다.
		int bigN = (number1 > number2) ? number1 : number2;
		int smallN = (number1 < number2) ? number1 : number2;

		// 입력받은 두 수가 배수관계에 있다면
		if(bigN % smallN == 0) {
			ans[0] = smallN; // 최대공약수는 두 수 중 작은 값
			ans[1] = bigN; // 최소공배수는 두 수 중 큰 값
		}else {
			// n1과 n2는 계산과정에서 나눠진 결과를 저장하는 변수
			int n1 = bigN;
			int n2 = smallN;
			
			// 두 수 중 작은 수부터 1까지 모든 수로 나눠보고 나누어 떨어질 때만 계산진행
			for(int i = smallN; i > 0; i--) {
				if( (n1 % i == 0) && (n2 %i == 0) ) { // 나누어 떨어질 때
					ans[0] *= i; // 나눈 수를 최대공약수에 곱한다.
					ans[1] *= i; // 나눈 수를 최소공배수에 곱한다.
					n1 /= i; // i로 나누고 난 값
					n2 /= i; // i로 나눈고 난 값
				}
			}
			// 최소공배수는 나누어떨어지지 않을때까지 나누고 난 값들도 곱해야하므로
			ans[1] = ans[1] * n1 * n2;
		}
		
		// 최대공약수와 최소공배수를 담은 배열 리턴
		return ans;
	} // findvalue함수 종료
}
