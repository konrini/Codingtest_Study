package boj.class2;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_10773 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt(); // 숫자를 몇 번 부를건지
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < cnt; i++) {
			int num = sc.nextInt();
			if(num == 0 && !stack.isEmpty()) { // 0을 외치면 가장 최근에 불렀던 수를 stack에서 제거
				stack.pop();
			} else { // 그 외 숫자가 들어오면 stack에 추가
				stack.add(num);
			}
		} // 숫자 외치기 종료
		
		int ans = 0;
		// stack에서 숫자 꺼내면서 ans에 더하기
		
		while(!stack.isEmpty()) {
			ans += stack.pop();
		}
		System.out.println(ans);
	}
}
