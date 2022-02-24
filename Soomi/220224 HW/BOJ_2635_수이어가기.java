import java.util.Scanner;
import java.util.Stack;

public class BOJ_2635_수이어가기{

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int max = 0;
		Stack<Integer> ans = new Stack<>();

		int a = sc.nextInt(); // 첫 수
		for (int i = a; i > 0; i--) {
			int A = a;
			int B = i; // 두 번째 수 B
			Stack<Integer> num = new Stack<>();
			
			num.add(A);
			num.add(B);

			for (;;) {
				
				int C = A - B;
				if (C >= 0) {
					num.add(C);
				} else {
					break;
				}
				A = B;
				B = C;
			}
			max = Math.max(max, num.size());
			if (num.size() == max) {
				ans = num;
			}
		} // B 바꾸기 종료

		System.out.println(max);
		Stack<Integer> valstack = new Stack<>();
		while(!ans.isEmpty()){
			valstack.push(ans.pop());
		}
		System.out.printf("%d", valstack.pop());
		while(!valstack.isEmpty()) {
			int val = valstack.pop();
			System.out.printf(" %d",val);
		}

	}

}
