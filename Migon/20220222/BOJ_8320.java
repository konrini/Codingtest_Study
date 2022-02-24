import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// n=1일 때
		int ans = 1;
		// 약수의 개수 세기
		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j <= Math.sqrt(i); ++j) {
				if (i % j == 0) {
					++ans;
				}
			}
		}
		System.out.println(ans);
	}
}