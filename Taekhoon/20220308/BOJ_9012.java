package boj.class2;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Stack<Character> stack = new Stack<>();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			stack.clear(); // 이전 tc에서 stack이 안 비워져있을수도 있으니 시원하게 비우고 감
			int cnt = 0;
			
			for (cnt = 0; cnt < str.length(); cnt++) {
				if (str.charAt(cnt) == '(') {
					stack.add(str.charAt(cnt));
				} else { // 닫는 괄호가 나왔을때
					if (!stack.isEmpty() && stack.peek() == '(') { // 스택이 안 비어있고 peek가 여는 괄호이면
						stack.pop(); // stack에서 제거
					} else if (stack.isEmpty()) { // 비어있으면 망한거
						System.out.println("NO");
						break;
					} 
				}
			} // for문 종료
			
			// for문 종료됐는데
			if (cnt == str.length() && !stack.isEmpty()) { // 안 비어있으면 망한거, cnt가 있는 이유는 위에서 끝까지 안돌고 break되었을때 잘못 출력되는 경우 방지용
				System.out.println("NO");
			} else if(cnt == str.length() && stack.isEmpty()){ // 비어있으면 성공!
				System.out.println("YES");
			}
		} //테스트케이스 종료

	}
}
