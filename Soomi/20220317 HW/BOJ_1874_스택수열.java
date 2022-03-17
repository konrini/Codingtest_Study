import java.util.Scanner;
import java.util.Stack;

public class BOJ_1874_스택수열 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();
		Stack<Integer> order = new Stack<Integer>();

		int[] seq = new int[n];

		for (int i = 0; i < n; i++) {
			seq[i] = sc.nextInt();
		} // 수열 입력 끝

		int a = 0;

		for (int i = 1; i <= n; i++) {

			order.push(i);
			sb.append("+\n");

			while (!order.isEmpty() && order.peek() == seq[a]){
				order.pop();
				sb.append("-\n");
				a++;
			}

		} // end for

		if (order.isEmpty()) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}

	}// end main

}
