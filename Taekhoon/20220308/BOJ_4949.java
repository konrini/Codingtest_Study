package boj.class2;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_4949 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean termination = true;
		Stack<Character> stack;
		String str;
		while (termination) { // . 하나만 입력되면 종료
			str = sc.nextLine();
			if (str.equals(".")) {
				termination = false;
				break;
			} else {
				stack = new Stack<>(); // 새로운 스택 생성
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '(' || str.charAt(i) == '[') { // 여는 괄호이면 stack에 추가
						stack.add(str.charAt(i));
					} else if (str.charAt(i) == ')') { // 닫는 소괄호가 나오면
						if (!stack.isEmpty() && stack.peek() == '(') { // 스택이 비어있지않고 stack의 peek가 여는 소괄호면 stack에서 pop
							stack.pop();
						} else { // 그렇지 않으면 괄호의 짝이 안 맞는 경우이므로
							System.out.println("no"); // no를 출력하고
							
							break; // for문 break
						}
					} else if (str.charAt(i) == ']') { // 닫는 대괄호가 나오면
						if (!stack.isEmpty() && stack.peek() == '[') {
							stack.pop();
						} else {
							System.out.println("no");
							
							break;
						}

					} else if( str.charAt(i) == '.' && stack.isEmpty()) { // 한 문장이 종료되고 스택이 비어있으면 성공! 
						System.out.println("yes");
					} else if( str.charAt(i) == '.' && !stack.isEmpty()){
						System.out.println("no");
					}
				}
			}
		}

	}
}
