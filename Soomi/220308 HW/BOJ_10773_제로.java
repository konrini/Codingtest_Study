import java.util.Scanner;
import java.util.Stack;

public class BOJ_10773_제로 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//숫자 저장할 stack 선언
		Stack<Integer> st = new Stack<>();
		//들어올 숫자 k개
		int k = sc.nextInt();
		
		for (int K = 0; K < k; K++) {
			
			int next = sc.nextInt();
			
			//0이 들어오면 숫자 pop
			if(next==0) {
				st.pop();
			}else {
				st.add(next);
			}
			
		}//for문 end
		
		int sum =0;
		for (int i = 0; i < st.size(); i++) {
			//stack에 남아있는 숫자들 더하기
			sum += st.elementAt(i);
		}
		
		System.out.println(sum);
	}

}
