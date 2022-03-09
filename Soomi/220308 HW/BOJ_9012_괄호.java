import java.util.Scanner;
import java.util.Stack;

public class BOJ_9012_괄호 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//T개의 줄 입력
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			//한 줄씩 s에 저장
			String s = sc.next();
			//stack 초기화
			Stack<Character> st = new Stack<>();
			boolean b = true;

			//s길이만큼 반복
			for (int i = 0; i < s.length(); i++) {
				//c에 하나씩 저장
				char c = s.charAt(i);

				//여는 괄호면 push, 다른 건 안 들어감
				if (c == '(') {
					st.push(c);
				//닫는 괄호면 여는 괄호 pop
				} else if (c == ')') {
					//빈 stack이면 false
					if (st.empty()) {
						b=false;
						break;
					} else {
						st.pop();
					}
				}

			}
			//false 아니고 비었으면 YES
			if(b && st.empty()) {
				System.out.println("YES");
			}else
				System.out.println("NO");

		}
	}

}
