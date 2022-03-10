import java.util.Scanner;
import java.util.Stack;

public class BOJ_4949_균형잡힌세상 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		while (true) {
			//stack 선언
			Stack<Character> st = new Stack<>();
			//한 줄씩 받기
			String s = sc.nextLine();
			boolean b = true;
			//.입력 받으면 끝
			if (s.equals(".")) {
				break;
			}

			//한 줄 길이만큼 반복
			for (int i = 0; i < s.length(); i++) {
				//c에 하나씩 저장
				char c = s.charAt(i);

				//여는 괄호면 push
				if (c == '(' || c == '[') {
					st.push(c);
				//닫는 괄호면 여는 괄호 pop
				} else if (c == ')') {
					//stack 비었거나 다른 괄호 들어있으면 false
					if (st.empty() || st.peek() != '(') {
						b=false;
						break;
					} else {
						st.pop();
					}
				} else if (c == ']') {
					if (st.empty() || st.peek() != '[') {
						b=false;
						break;
					} else {
						st.pop();
					}
				}

			}

			//true이고, stack 비었으면 yes
			if (b&&st.empty()) {
				System.out.println("yes");
			}else
				System.out.println("no");

		}//while문 end
	}

}
